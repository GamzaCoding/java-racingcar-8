package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Parsing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class racingcarController {

    private final InputView inputView;
    private final OutputView outputView;

    public racingcarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printInit();
        String names = inputView.inputCarName();
        List<String> nameList = Parsing.parsingName(names);

        List<Car> carList = new ArrayList<>();

        // parsing된 이름을 바탕으로 자동차 생성 -> 자동차 리스트에 추가 로직
        nameList.stream()
                .map(Car::new)
                .forEach(carList::add);

        outputView.printTryCount();
        int tryCount = inputView.inputTryCount();

        outputView.printRacingResult();

        // 각 자동차들 이동 로직, povi : -- 이런식으로 결과 출력하는 로직
        for (int i = 0; i < tryCount; i++) {
            carList.stream()
                    .peek(Car::move)
                    .forEach(outputView::printCarMoved);
            System.out.println();
        }

        // 가장 많이 이동한 거리 구하는 로직
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("차가 없습니다."));

        // 우승자 구하는 로직
        List<String> winner = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        // 우승자 출력 로직
        if (winner.size() == 1) {
            String resultWinner = winner.get(0);
            outputView.printWinner(resultWinner);
        } else {

            String resultWinners = String.join(", ", winner);
            outputView.printWinner(resultWinners);
        }
    }
}

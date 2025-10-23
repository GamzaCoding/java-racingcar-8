package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
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

        Cars cars = new Cars(names);
        List<Car> carList = cars.getCars();

        // 시도 횟수 물어보는 로직
        outputView.printTryCount();
        int tryCount = inputView.inputTryCount();

        System.out.println();

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

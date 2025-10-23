package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingRound;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingcarController() {
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

        RacingRound racingRound = new RacingRound(tryCount);
        while (racingRound.hasNextRound()) {
            racingRound.playRacingRound();
            carList.forEach(
                    car -> {
                        car.move();
                        outputView.printCarMoved(car);
                    });
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

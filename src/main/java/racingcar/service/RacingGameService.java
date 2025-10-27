package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingRound;
import racingcar.model.moveStrategy.MoveStrategy;
import racingcar.model.moveStrategy.RandomMoveStrategy;

public class RacingGameService {

    private static final String DELIMITER = ",";

    private final Cars cars;
    private final RacingRound racingRound;
    private final MoveStrategy movementStrategy;

    public RacingGameService(String carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.racingRound = new RacingRound(tryCount);
        this.movementStrategy = new RandomMoveStrategy();
    }

    public boolean hasNextRound() {
        return racingRound.hasNextRound();
    }

    public void playRound() {
        racingRound.progressRound();

        cars.getCars()
                .forEach(car -> car.move(movementStrategy));
    }

    public List<CarDto> roundResult() {
        return cars.getCarDto();
    }

    public List<String> getWinner() {
        int maxPosition = cars.findMaxPosition();
        return cars.getCars().stream()
                .filter(car -> isWinner(car, maxPosition))
                .map(Car::getName)
                .toList();
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    private Cars createCars(String carNames) {
        return new Cars(parsingName(carNames));
    }

    private List<String> parsingName(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}

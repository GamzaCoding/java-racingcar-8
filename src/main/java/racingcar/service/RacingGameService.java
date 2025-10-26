package racingcar.service;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingRound;
import racingcar.model.movementStrategy.MovementStrategy;
import racingcar.model.movementStrategy.RandomMovementStrategy;
import racingcar.utility.Parsing;

public class RacingGameService {

    private final Cars cars;
    private final RacingRound racingRound;
    private final MovementStrategy movementStrategy;

    public RacingGameService(String carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.racingRound = new RacingRound(tryCount);
        this.movementStrategy = new RandomMovementStrategy();
    }

    public boolean hasNextRound() {
        return racingRound.hasNextRound();
    }

    public void playRound() {
        racingRound.progressRound();

        cars.getCars().forEach(car -> car.move(movementStrategy));
    }

    public List<CarDto> roundResult() {
        return cars.getCarDto();
    }

    public List<String> getWinner() {
        int maxPosition = cars.findMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private Cars createCars(String carNames) {
        return new Cars(Parsing.parsingName(carNames));
    }
}

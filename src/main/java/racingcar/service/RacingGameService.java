package racingcar.service;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingRound;

public class RacingGameService {

    private Cars cars;
    private RacingRound racingRound;

    public void createCars(String carsNames) {
        this.cars = new Cars(carsNames);
    }

    public void initRacingRound(int tryCount) {
        this.racingRound = new RacingRound(tryCount);
    }

    // createCars, initRacingRound 보다 다른 메서드가 먼저 호출되면 nullPointException이 발생하는 문제가 있다.

    public boolean hasNextRound() {
        return racingRound.hasNextRound();
    }

    public void playRound() {
        racingRound.progressRound();

        cars.getCars()
                .forEach(Car::move);
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
}

package racingcar.sevice;

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

    public void settingRacingRound(int tryCount) {
        this.racingRound = new RacingRound(tryCount);
    }

    public boolean hasNextRound() {
        return racingRound.hasNextRound();
    }

    public void playRacing() {
        racingRound.playRound(); // 상태를 변화시키는 메서드를 호출 하는 것임

        cars.getCars()
                .forEach(Car::move);
    }

    public List<CarDto> roundResult() {
        return cars.getCarDto();
    }

    public int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("차가 없습니다."));
    }

    public List<String> getWinner(int maxPosition) {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}

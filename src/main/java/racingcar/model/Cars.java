package racingcar.model;

import static racingcar.validation.Validation.*;

import java.util.List;
import racingcar.dto.CarDto;

public class Cars {

    private static final int ZERO_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateNameDuplication(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO_POSITION);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public List<CarDto> getCarDto() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }
}

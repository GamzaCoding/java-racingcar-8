package racingcar.model;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.validation.Validation;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        Validation.validateDuplicateName(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("차가 없습니다."));
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

package racingcar.model;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.utility.Parsing;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = Parsing.parsingName(carNames).stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarDto> getCarDto() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .toList();
    }
}

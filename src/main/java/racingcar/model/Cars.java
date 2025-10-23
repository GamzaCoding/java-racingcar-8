package racingcar.model;

import java.util.List;
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
}

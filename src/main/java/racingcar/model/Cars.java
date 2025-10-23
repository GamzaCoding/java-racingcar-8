package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        List<String> nameList = Parsing.parsingName(carNames);

        nameList.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public List<Car> getCars() {
        return cars;
    }
}

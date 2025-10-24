package racingcar.service;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingRound;
import racingcar.utility.Parsing;

public class RacingGameService {

    private final Cars cars;
    private final RacingRound racingRound;

    public RacingGameService(String carNames, int tryCount) {
        this.cars = new Cars(makeCarsList(carNames));
        this.racingRound = new RacingRound(tryCount);
    }

    // 이 부분 추가 리팩터링 필요해보임
    private List<String> makeCarsList(String carNames) {
        return Parsing.parsingName(carNames);
    }

    public boolean hasNextRound() {
        return racingRound.hasNextRound();
    }

    public void playRound() {
        racingRound.progressRound();

        cars.getCars().forEach(Car::move);
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

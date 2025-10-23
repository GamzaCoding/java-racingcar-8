package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 4;
    }
}

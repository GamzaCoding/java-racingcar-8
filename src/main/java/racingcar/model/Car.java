package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void move() {
        if (canMove()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}

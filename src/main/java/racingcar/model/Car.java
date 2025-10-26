package racingcar.model;

import racingcar.model.moveStrategy.MoveStrategy;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position = DEFAULT_POSITION;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position += MoveStrategy.MOVE_AMOUNT;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.get();
    }
}

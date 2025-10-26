package racingcar.model;

import racingcar.model.movementStrategy.MovementStrategy;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVEMENT_AMOUNT = 1;

    private final Name name;
    private int position = DEFAULT_POSITION;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(MovementStrategy movementStrategy) {
        if (movementStrategy.canMove()) {
            position += MOVEMENT_AMOUNT;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.get();
    }
}

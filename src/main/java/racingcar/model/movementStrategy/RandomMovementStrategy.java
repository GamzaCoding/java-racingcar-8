package racingcar.model.movementStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int THRESHOLD_NUMBER = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= THRESHOLD_NUMBER;
    }
}

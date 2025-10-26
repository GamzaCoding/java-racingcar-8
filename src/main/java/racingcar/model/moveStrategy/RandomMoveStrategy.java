package racingcar.model.moveStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int THRESHOLD_NUMBER = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= THRESHOLD_NUMBER;
    }
}

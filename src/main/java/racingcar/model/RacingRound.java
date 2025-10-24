package racingcar.model;

public class RacingRound {

    private static final int ZERO = 0;

    private int tryCount;

    public RacingRound(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean hasNextRound() {
        return tryCount > ZERO;
    }

    public void progressRound() {
        tryCount--;
    }
}

package racingcar.model;

public class RacingRound {

    private static final int ZERO_COUNT = 0;

    private int tryCount;

    public RacingRound(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean hasNextRound() {
        return tryCount > ZERO_COUNT;
    }

    public void progressRound() {
        tryCount--;
    }
}

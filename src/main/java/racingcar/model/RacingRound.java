package racingcar.model;

public class RacingRound {
    private int tryCount;

    public RacingRound(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean hasNextRound() {
        return tryCount > 0;
    }

    public void progressRound() {
        tryCount--;
    }
}

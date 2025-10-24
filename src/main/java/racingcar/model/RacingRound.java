package racingcar.model;

public class RacingRound {
    private int tryCount;

    public RacingRound(int tryCount) {
        validatePositive(tryCount);
        this.tryCount = tryCount;
    }

    public boolean hasNextRound() {
        return tryCount > 0;
    }

    public void progressRound() {
        tryCount--;
    }

    private void validatePositive(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수를 입력하셔야 합니다.");
        }
    }
}

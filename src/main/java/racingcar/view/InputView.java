package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    private static final String CAR_NAMES_REGEX = "^[a-zA-Z]+(\\s*,\\s*[a-zA-Z]+)*\\s*$";

    public String inputCarName() {
        String carNames = readLine().trim();
        validateNameFormat(carNames);

        return carNames;
    }

    public int inputTryCount() {
        String tryCount = readLine();
        validateIntegerFormat(tryCount);

        int count = stringToInt(tryCount);
        validatePositiveNumber(count);

        return count;
    }

    private void validatePositiveNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
    }

    private void validateIntegerFormat(String tryCount) {
        try {
            stringToInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해야 합니다.");
        }
    }

    private void validateNameFormat(String carNames) {
        if (carNames.matches(CAR_NAMES_REGEX)) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름 입력 양식을 다시 확인해주세요");
    }

    private int stringToInt(String tryCount) {
        return Integer.parseInt(tryCount);
    }
}

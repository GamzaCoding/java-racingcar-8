package racingcar.validation;

import java.util.List;
import java.util.Set;

public class Validation {

    private static final String CAR_NAMES_REGEX = "^[a-zA-Z]+(\\s*,\\s*[a-zA-Z]+)*\\s*$";

    public static void validateNameFormat(String inputCarNames) {
        if (inputCarNames.matches(CAR_NAMES_REGEX)) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름 입력 양식을 다시 확인해주세요");
    }

    public static void validateDuplicateName(List<String> carNames) {
        if(carNames.size() != Set.copyOf(carNames).size()) {
            throw new IllegalArgumentException("이름이 중복되었습니다. 서로 다른 이름을 입력해주세요");
        }
    }

    public static void validatePositiveNumber(String tryCount) {
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수를 입력해야 합니다.");
        }
    }

    public static void validateIntegerFormat(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해야 합니다.");
        }
    }

    public static void validateNameLengthUnderFive(String name) {
        if (name.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
    }
}

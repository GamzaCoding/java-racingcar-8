package racingcar.validation;

import java.util.List;
import java.util.Set;

public class Validation {

    private static final String CAR_NAMES_REGEX = "^[a-zA-Z]+(\\s*,\\s*[a-zA-Z]+)*\\s*$";
    private static final String NAME_FORMAT_ERROR_MESSAGE = "자동차 이름 입력 양식을 다시 확인해주세요.";
    private static final String NAME_DUPLICATION_ERROR_MESSAGE = "이름이 중복되었습니다. 서로 다른 이름을 입력해주세요.";
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "이름은 5글자 이하만 가능합니다.";
    private static final String POSITIVE_NUMBER_ERROR_MESSAGE = "시도 횟수는 양의 정수를 입력해야 합니다.";
    private static final String INTEGER_FORMAT_ERROR_MESSAGE = "시도 횟수는 숫자를 입력해야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int ZERO_NUMBER = 0;

    public static void validateNameFormat(String inputCarNames) {
        if (inputCarNames.matches(CAR_NAMES_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
    }

    public static void validateNameDuplication(List<String> carNames) {
        if (carNames.size() != Set.copyOf(carNames).size()) {
            throw new IllegalArgumentException(NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public static void validateMaxNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validatePositiveNumber(String tryCount) {
        if (Integer.parseInt(tryCount) <= ZERO_NUMBER) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateIntegerFormat(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_FORMAT_ERROR_MESSAGE);
        }
    }
}

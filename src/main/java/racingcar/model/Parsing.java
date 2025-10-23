package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Parsing {

    public static List<String> parsingName(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .peek(Parsing::validateNameLengthUnderFive)
                .toList();
    }

    private static void validateNameLengthUnderFive(String name) {
        if (name.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
    }
}

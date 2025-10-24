package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public class Parsing {

    private static final String DELIMITER = ",";

    public static List<String> parsingName(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}

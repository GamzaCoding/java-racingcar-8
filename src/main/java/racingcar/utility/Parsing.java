package racingcar.utility;

import java.util.Arrays;
import java.util.List;

public class Parsing {

    public static List<String> parsingName(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
    }
}

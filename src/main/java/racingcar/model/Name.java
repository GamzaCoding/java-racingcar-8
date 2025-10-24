package racingcar.model;

import static racingcar.validation.Validation.*;

public class Name {

    private final String name;

    public Name(String name) {
        validateNameLengthUnderFive(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

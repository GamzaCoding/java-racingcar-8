package racingcar.model;

import static racingcar.validation.Validation.*;

public class Name {

    private final String name;

    public Name(String name) {
        validateMaxNameLength(name);
        this.name = name;
    }

    public String get() {
        return name;
    }
}

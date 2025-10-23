package racingcar.model;

public class Name {

    private final String name;

    public Name(String name) {
        validateNameLengthUnderFive(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void validateNameLengthUnderFive(String name) {
        if (name.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
    }
}

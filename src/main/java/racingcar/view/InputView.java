package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.validation.Validation.*;

public class InputView {

    public String inputCarName() {
        String carNames = readLine().trim();
        validateNameFormat(carNames);

        return carNames;
    }

    public int inputTryCount() {
        String tryCount = readLine();
        validateIntegerFormat(tryCount);
        validatePositiveNumber(tryCount);

        return Integer.parseInt(tryCount);
    }
}

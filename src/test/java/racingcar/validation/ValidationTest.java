package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.validation.Validation.*;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 자동차_이름_입력_형식_테스트() {
        // given
        String inputNames = "gamza,faker, doran";
        // then
        assertDoesNotThrow(() -> validateNameFormat(inputNames));
    }

    @Test
    void 자동차_이름_한글_입력시_오류_테스트() {
        // given
        String inputNames = "감자, faker, doran";
        // then
        assertThatThrownBy(() -> validateNameFormat(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 입력 양식을 다시 확인해주세요.");
    }

    @Test
    void 시도_횟수_양수_입력_테스트() {
        // given
        String inputNumber = "11";
        // then
        assertDoesNotThrow(() -> validatePositiveNumber(inputNumber));
    }

    @Test
    void 시도_횟수_음수_입력시_에러_테스트() {
        // given
        String inputNumber = "-1";
        // then
        assertThatThrownBy(() -> validatePositiveNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수를 입력해야 합니다.");
    }

    @Test
    void 시도_횟수_0_입력시_에러_테스트() {
        // given
        String inputNumber = "0";
        // then
        assertThatThrownBy(() -> validatePositiveNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수를 입력해야 합니다.");
    }

    @Test
    void 시도_횟수_문자로_입력시_에러_테스트() {
        // given
        String inputNumber = "number";
        // then
        assertThatThrownBy(() -> validateIntegerFormat(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자를 입력해야 합니다.");
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_이름_중복_테스트() {
        // given
        List<String> duplicateNames = List.of("gamza", "gamza", "faker");

        // then
        assertThatThrownBy(() -> new Cars(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 중복되었습니다. 서로 다른 이름을 입력해주세요.");
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        Car gamzaCar = new Car("gamza");
        Car fakerCar = new Car("faker");
        Car doranCar = new Car("Doran");
        // when
        String gamzaName = "gamza";
        String fakerName = "faker";
        String doranName = "Doran";
        // then
        assertThat(gamzaCar.getName()).isEqualTo(gamzaName);
        assertThat(fakerCar.getName()).isEqualTo(fakerName);
        assertThat(doranCar.getName()).isEqualTo(doranName);
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.movementStrategy.MovementStrategy;

class CarTest {

    @Test
    void 자동차_이름_테스트() {
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

    @Test
    void 자동차_1칸_이동_테스트() {
        // given
        Car car = new Car("gamza");
        MovementStrategy alwaysMoventStrategy = () -> true;
        // when
        car.move(alwaysMoventStrategy);
        int exceptPosition = 1;
        // then
        assertThat(car.getPosition()).isEqualTo(exceptPosition);
    }

    @Test
    void 자동차_이동_실패_테스트() {
        // given
        Car car = new Car("gamza");
        MovementStrategy alwaysMoventStrategy = () -> false;
        // when
        car.move(alwaysMoventStrategy);
        int exceptPosition = 0;
        // then
        assertThat(car.getPosition()).isEqualTo(exceptPosition);
    }
}

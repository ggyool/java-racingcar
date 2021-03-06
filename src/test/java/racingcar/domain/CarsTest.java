package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.DefinitelyMovingStrategy;
import racingcar.domain.movingstrategy.SwitchedMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @DisplayName("Car가 중복되지 않는 경우 객체 생성 성공")
    @Test
    public void create_success() {
        final List<Car> cars = Arrays.asList(
                new Car(new Name("dani")),
                new Car(new Name("pobi")),
                new Car(new Name("bear"))
        );

        assertThatCode(() -> Cars.create(cars))
                .doesNotThrowAnyException();
    }

    @DisplayName("Car가 중복되는 경우 예외 발생")
    @Test
    public void create_fail() {
        final List<Car> cars = Arrays.asList(
                new Car(new Name("dani")),
                new Car(new Name("pobi")),
                new Car(new Name("bear")),
                new Car(new Name("bear"))
        );

        assertThatThrownBy(() -> {
            Cars.create(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 중복되지 않는 경우 객체 생성 성공")
    @Test
    public void createByName_이름이_중복되지_않는_경우() {
        final List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "bear"});

        assertThatCode(() -> Cars.createByName(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 중복되는 경우 예외 발생")
    @Test
    public void createByName_이름이_중복되는_경우() {
        final List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "dani", "bear"});

        assertThatThrownBy(() -> {
            Cars.createByName(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최종 우승자 판단 성공")
    @Test
    void getWinners() {
        final List<Car> carList = Arrays.asList(
                new Car(new Name("dani"), Position.from(0), DefinitelyMovingStrategy.getInstance()),
                new Car(new Name("pobi"), Position.from(0), new SwitchedMovingStrategy()),
                new Car(new Name("bear"), Position.from(0), new SwitchedMovingStrategy())
        );
        Cars cars = Cars.create(carList);

        final int movingCount = 10;
        for (int i = 0; i < movingCount; i++) {
            cars = cars.move();
        }

        final List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactly(
                new Car(new Name("dani"), Position.from(movingCount), DefinitelyMovingStrategy.getInstance())
        );
    }
}

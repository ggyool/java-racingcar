package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void create(){
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    /*@Test
    void 난수생성테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num);
            assertThat(num).isLessThan(10);
            assertThat(num).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 자동차가_움직이는조건_테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num + " " + car.isPossibleMove(num));
        }
    }*/

    @Test
    void 숫자가_4이하일때_움직이지않는지_테스트() {
        String before = car.toString();
        car.move(4);
        String after = car.toString();

        assertThat(after).isEqualTo(before);
    }

    @Test
    void 숫자가_5이상일때_움직이는지_테스트() {
        String before = car.toString();
        car.move(5);
        String after = car.toString();

        assertThat(after).isEqualTo("-" + before);
    }

    @Test
    void 최댓값_테스트() {
        List<Car> cars = new ArrayList<>(
                Arrays.asList(new Car("a", 2), new Car("b", 5), new Car("c", 4))
        );

        assertThat(Collections.max(cars).compareTo(new Car(null, 5))).isEqualTo(0);
    }
}
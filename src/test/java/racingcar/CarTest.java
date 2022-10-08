package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void 자동차_객체_생성(){
        Car car = new Car("car1");
        assertEquals("car1", car.getName());
    }

    @Test
    void 자동차_이름_길이_5자_초과(){
        assertThatThrownBy(() -> new Car("seogineer")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
    }

    @Test
    void 자동차_주행(){
        Car car = new Car("test");
        for(int i = 0; i < 5; i++){
            car.location.goStop();
        }
        System.out.println(car.goCount());
        System.out.println(car.location());
    }
}

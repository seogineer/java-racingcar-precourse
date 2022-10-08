package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void 자동차_객체_생성(){
        Car car = new Car("car");
        assertEquals("car", car.getName());
    }

    @Test
    void 자동차_이름_길이_5자_초과(){
        assertThatThrownBy(() -> new Car("seogineer")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
    }

    @Test
    void 자동차_이름이_한글인_경우(){
        assertThatThrownBy(() -> new Car("자동차")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 영문만 가능합니다.");
    }

    @Test
    void 자동차_이름이_특수문자인_경우(){
        assertThatThrownBy(() -> new Car("$%^&*")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 영문만 가능합니다.");
    }

    @Test
    void 자동차_이름이_공백인_경우(){
        assertThatThrownBy(() -> new Car(" ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 영문만 가능합니다.");
    }

    @Test
    void 자동차_이름이_null인_경우(){
        assertThatThrownBy(() -> new Car(null)).isInstanceOf(NullPointerException.class);
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

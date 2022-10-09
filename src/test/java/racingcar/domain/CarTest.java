package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void 자동차_객체_생성(){
        Car car = new Car("car");
        assertEquals("car", car.getName());
    }

    @Test
    void 자동차_주행(){
        Car car = new Car("pobi");
        for(int i = 0; i < 5; i++){
            car.location.goStop();
        }
        System.out.println(car.getName() + " : " + car.location());
    }
}

package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차_이름_중복_검사(){
        assertThatThrownBy(() -> new Cars(new String[]{"pobi", "pobi", "crong"})).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복 입력이 불가능합니다.");
    }

    @Test
    void 자동차_go_또는_stop(){
        Cars cars = new Cars(new String[]{"pobi", "honux", "crong"});
        for(int i = 0; i < 5; i++){
            cars.goOrStop();
        }
    }

    @Test
    void 최종_우승자_확인(){
        Cars cars = new Cars(new String[]{"pobi", "honux", "crong"});
        for(int i = 0; i < 5; i++){
            cars.goOrStop();
        }
        cars.getWinner();
    }
}

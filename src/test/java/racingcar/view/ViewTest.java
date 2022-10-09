package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {
    private View view = new View();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong"})
    void 자동차_이름_입력_화면(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        new Scanner(System.in);

        String[] names = view.inputCarNameView();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                outputStreamCaptor.toString().trim());
        assertEquals(3, names.length);
        assertEquals("pobi", names[0]);
        assertEquals("honux", names[1]);
        assertEquals("crong", names[2]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void 시도_횟수_입력_화면(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        new Scanner(System.in);

        assertEquals(5, view.inputTryCountView());
        assertEquals("시도할 회수는 몇회인가요?", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void 시도_횟수_음수_입력(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        new Scanner(System.in);

        assertThatThrownBy(() -> view.inputTryCountView()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void 시도_횟수_영문_입력(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        new Scanner(System.in);

        assertThatThrownBy(() -> view.inputTryCountView()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 실행_결과_문장_표시_화면(){
        view.outputResultView();
        assertEquals("실행 결과", outputStreamCaptor.toString().trim());
    }
}

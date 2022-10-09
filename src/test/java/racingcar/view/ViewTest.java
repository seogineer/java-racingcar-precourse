package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final View view = new View();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 자동차_이름_입력_화면(){
        view.inputCarNameView();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void 시도_횟수_입력_화면(){
        view.inputTryCountView();
        assertEquals("시도할 회수는 몇회인가요?", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void 실행_결과_화면(){
        view.resultView();
        assertEquals("실행 결과", outputStreamCaptor.toString()
                .trim());
    }
}

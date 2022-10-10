package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {
    private View view = new View();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        outputStreamCaptor.reset();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong"})
    void 자동차_이름_입력_화면(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
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
    @ValueSource(strings = {"pobi,javaji"})
    void 자동차_이름_길이_5자_초과(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능하다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n"})
    void 자동차_이름_길이_1자_미만(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능하다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 자동차_이름_공백_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 자동차 이름으로 공백은 불가능하다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    void 자동차_이름_중복_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputCarNameView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 자동차 이름은 중복 입력이 불가능하다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void 시도_횟수_입력_화면(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        assertEquals(5, view.inputTryCountView());
        assertEquals("시도할 횟수는 몇회인가요?", outputStreamCaptor.toString().trim());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void 시도_횟수_음수_입력(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputTryCountView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 시도 횟수는 정수 또는 숫자여야 한다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void 시도_횟수_문자_입력(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        try { view.inputTryCountView(); } catch (final NoSuchElementException ignore){}
        assertThat(outputStreamCaptor.toString().trim()).contains("[ERROR] 시도 횟수는 정수 또는 숫자여야 한다.");
    }
}

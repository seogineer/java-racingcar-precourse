package racingcar.view;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    public String[] inputCarNameView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine().split(",");
    }

    public int inputTryCountView() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(tryCountValidate(readLine()));
    }

    public void outputResultView() {
        System.out.println("실행 결과");
    }

    private String tryCountValidate(String count){
        if(!Pattern.matches("^[0-9]*$", count)){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return count;
    }
}

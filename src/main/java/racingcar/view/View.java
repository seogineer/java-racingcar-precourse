package racingcar.view;

import racingcar.validate.Validate;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private final Validate validate = new Validate();

    public String[] inputCarNameView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names;
        do {
            names = readLine().split(",");
        } while (!validate.isValidInputNames(names));
        return names;
    }

    public int inputTryCountView() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String count;
        do {
            count = readLine();
        } while(!validate.isValidCount(count));
        return Integer.parseInt(count);
    }

    public void outputResultView() {
        System.out.println();
        System.out.println("실행 결과");
    }
}

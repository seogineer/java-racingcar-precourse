package racingcar.validate;

import java.util.regex.Pattern;

public class Validate {
    public boolean isValidInputNames(String[] names){
        for(String name : names){
            if(!validateName(name)){
                return false;
            }
            if(!isDuplicate(name, names)){
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(String name, String[] names){
        int count = 0;
        for(String nameInArr : names){
            if(nameInArr.equals(name)){
                count++;
            }
            if(count > 1){
                System.out.println("[ERROR] 자동차 이름은 중복 입력이 불가능합니다.");
                return false;
            }
        }
        return true;
    }

    private boolean validateName(String name){
        if(name.length() > 5){
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            return false;
//            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
        }
        return true;
    }

    public boolean isValidCount(String count){
        if(!Pattern.matches("^[0-9]*$", count)){
            System.out.println("[ERROR] 시도 횟수는 정수 또는 숫자여야 합니다.");
            return false;
//            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return true;
    }
}

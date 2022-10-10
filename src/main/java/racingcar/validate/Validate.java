package racingcar.validate;

import java.util.regex.Pattern;

public class Validate {
    public boolean isValidInputNames(String[] names){
        try {
            validateName(names);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateName(String[] names){
        for(String name : names){
            if(name.length() > 5 || name.length() < 1){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능하다.");
            }
            if(name.equals(" ")){
                throw new IllegalArgumentException("[ERROR] 자동차 이름으로 공백은 불가능하다.");
            }
            if(!isDuplicate(name, names)){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복 입력이 불가능하다.");
            }
        }
    }

    private boolean isDuplicate(String name, String[] names){
        int count = 0;
        for(String nameInArr : names){
            if(nameInArr.equals(name)){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

    public boolean isValidCount(String count){
        try {
            validateCount(count);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateCount(String count){
        if(!Pattern.matches("^[0-9]*$", count)){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수 또는 숫자여야 한다.");
        }
    }
}

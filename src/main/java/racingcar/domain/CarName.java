package racingcar.domain;

import java.util.regex.Pattern;

public class CarName {
    private final String name;

    public CarName(String name){
        validName(name);
        this.name = name;
    }

    private void validName(String name){
        if(name == null){
            throw new NullPointerException();
        }
        if(!Pattern.matches("^[a-zA-Z]*$", name)){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영문만 가능합니다.");
        }
        if(name.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
        }
    }

    public String getName() {
        return name;
    }
}

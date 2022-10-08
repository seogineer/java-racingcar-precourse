package racingcar;

public class CarName {
    private final String name;

    public CarName(String name){
        validName(name);
        this.name = name;
    }

    private void validName(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
        }
    }

    public String getName() {
        return name;
    }
}

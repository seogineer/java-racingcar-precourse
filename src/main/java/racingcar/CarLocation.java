package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarLocation {
    private int goCount;
    private final StringBuilder location;

    public CarLocation(){
        this.goCount = 0;
        location = new StringBuilder();
    }

    public void goStop(){
        if(pickNumberInRange(0, 9) >= 4){
            goCount++;
            location.append("-");
        }
    }

    public int getGoCount() {
        return goCount;
    }

    public StringBuilder getLocation() {
        return location;
    }
}

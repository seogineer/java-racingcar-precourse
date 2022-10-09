package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] participants){
        this.cars = addCar(participants);
    }

    private List<Car> addCar(String[] participants){
        List<Car> cars = new ArrayList<>();
        for (String participant : participants) {
            isDuplicate(participant, cars);
            cars.add(new Car(participant));
        }
        return cars;
    }

    private void isDuplicate(String name, List<Car> cars){
        for(Car car : cars){
            if(car.getName().equals(name)){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복 입력이 불가능합니다.");
            }
        }
    }

    public void goOrStop() {
        for(Car car : cars){
            car.location.goStop();
            System.out.println(car.getName() + " : " + car.location());
        }
        System.out.println();
    }

    public void getWinner() {
        StringBuilder winner = new StringBuilder();
        int max = -1;
        for(Car car : cars){
            if(car.location().length() > max){
                max = car.location().length();
                winner.setLength(0);
                winner.append(car.getName());
                continue;
            }
            if(car.location().length() == max){
                winner.append(", ").append(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winner);
    }
}

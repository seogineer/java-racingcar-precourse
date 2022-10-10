package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.View;

public class Racing {
    private final View view = new View();

    public void start(){
        Cars cars = new Cars();
        cars.addCar(view.inputCarNameView());
        int tryCount = view.inputTryCountView();
        view.outputResultView();
        for(int i = 0; i < tryCount; i++){
            cars.goOrStop();
        }
        cars.getWinner();
    }
}

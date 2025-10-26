package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingcarController = new RacingGameController(new InputView(), new OutputView());
        racingcarController.run();
    }
}

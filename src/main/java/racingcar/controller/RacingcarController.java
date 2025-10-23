package racingcar.controller;

import java.util.List;
import racingcar.sevice.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingcarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        gameSetting();
        gamePlay();
        gameResult();
    }

    private void gameSetting() {
        outputView.printInit();
        racingGameService.createCars(inputView.inputCarName());
        outputView.printTryCount();
        racingGameService.settingRacingRound(inputView.inputTryCount());
        System.out.println(); // 이부분 어떻게 좀 하자
    }

    private void gamePlay() {
        outputView.printRacingResult();

        while (racingGameService.hasNextRound()) {
            racingGameService.playRacing();
            outputView.printRoundResult(racingGameService.roundResult());
        }
    }

    private void gameResult() {

        // 가장 많이 이동한 거리 구하는 로직
        int maxPosition = racingGameService.getMaxPosition();

        // 우승자 구하는 로직
        List<String> winner = racingGameService.getWinner(maxPosition);

        // 우승자 출력 로직
        outputView.printWinner(winner);
    }
}

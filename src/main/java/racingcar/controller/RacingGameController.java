package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController() {
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
        outputView.printInitMessage();
        racingGameService.createCars(inputView.inputCarName());
        outputView.printRequestMessageOfTryCount();
        racingGameService.initRacingRound(inputView.inputTryCount());
    }

    private void gamePlay() {
        outputView.printRacingResultMessage();

        while (racingGameService.hasNextRound()) {
            racingGameService.playRound();
            outputView.printRoundResult(racingGameService.roundResult());
        }
    }

    private void gameResult() {
        outputView.printWinner(racingGameService.getWinner());
    }
}

package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGameService racingGameService = setupGame();
        playGame(racingGameService);
        showWinner(racingGameService);
    }

    private RacingGameService setupGame() {
        outputView.printInitMessage();
        String carNames = inputView.inputCarNames();
        outputView.printRequestMessageOfTryCount();
        int tryCount = inputView.inputTryCount();

        return new RacingGameService(carNames, tryCount);
    }

    private void playGame(RacingGameService racingGameService) {
        outputView.printRacingResultMessage();

        while (racingGameService.hasNextRound()) {
            racingGameService.playRound();
            outputView.printRoundResult(racingGameService.roundResult());
        }
    }

    private void showWinner(RacingGameService racingGameService) {
        outputView.printWinner(racingGameService.getWinner());
    }
}

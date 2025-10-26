package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String ONE_STEP = "-";
    private static final String INIT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String WINNER = "최종 우승자 : ";

    public void printInitMessage() {
        System.out.println(INIT_MESSAGE);
    }

    public void printRequestMessageOfTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    public void printRacingResultMessage() {
        lineBreaksForUi();
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void printRoundResult(List<CarDto> carDtos) {
        carDtos.forEach(this::printCarMoved);
        lineBreaksForUi();
    }

    public void printWinner(List<String> winners) {
        String result = String.join(COMMA, winners);
        System.out.println(WINNER + result);
    }

    private void printCarMoved(CarDto carDto) {
        System.out.println(carDto.name() + COLON + ONE_STEP.repeat(carDto.position()));
    }

    private void lineBreaksForUi() {
        System.out.println();
    }
}

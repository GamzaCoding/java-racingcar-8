package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String ONE_STEP = "-";

    public void printInitMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestMessageOfTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printWinnerFo(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printRoundResult(List<CarDto> carDtos) {
        carDtos.forEach(this::printCarMoved);
        System.out.println();
    }

    private void printCarMoved(CarDto carDto) {
        System.out.println(carDto.name() + " : " + ONE_STEP.repeat(carDto.position()));
    }

    public void printWinner(List<String> winner) {
        String result = String.join(", ", winner);
        printWinnerFo(result);
    }
}

package racingcar.view;

public class OutputView {

    private static final String ONE_STEP = "-";

    public void printInit() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResult() {
        System.out.println("실행 결과");
    }

    public void printWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }

// 일단 이렇게 될거 같으니까 만들어 두는 느낌
//    public void printCarMoved(Car car) {
//        System.out.println(car.name() + " : " + ONE_STEP.repeat(car.distance()) );
//    }
}

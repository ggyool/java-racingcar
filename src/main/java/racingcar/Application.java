package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Times;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final RacingCarController racingCarController = new RacingCarController(scanner);
        final List<String> carNames = racingCarController.scanCarNames();
        Times times = racingCarController.scanTimes();
        Cars cars = Cars.createByName(carNames);

        racingCarController.printResultGuide();
        while (times.isRemain()) {
            times = times.reduce();
            cars = cars.move();
            racingCarController.printResults(cars);
        }

        cars = Cars.create(cars.getWinners());
        racingCarController.printWinnerNames(cars);
    }
}

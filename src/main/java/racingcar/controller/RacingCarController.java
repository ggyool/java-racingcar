package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public List<String> scanCarNames() {
        return inputView.scanCarNames();
    }

    public Times scanTimes() {
        return new Times(inputView.scanTimes());
    }

    public void printResultGuide() {
        OutputView.printResultGuide();
    }

    public void printResults(final Cars cars) {
        OutputView.printResults(cars.toDtos());
    }

    public void printWinnerNames(final Cars cars) {
        OutputView.printWinnerNames(cars.toNameDtos());
    }
}

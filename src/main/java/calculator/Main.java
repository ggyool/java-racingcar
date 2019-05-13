package calculator;

import java.util.Scanner;

import calculator.domain.Calculator;
import calculator.validator.Validator;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean result;
		String value;

		do {
			System.out.println("계산식을 입력해주세요.");
			value = scanner.nextLine();
			result = Validator.validateAll(value);
		}
		while (!result);

		Calculator calculator = new Calculator(value.split(" "));
		System.out.println(calculator.calculate());
	}
}
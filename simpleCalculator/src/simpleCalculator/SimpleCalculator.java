package simpleCalculator;

import java.util.Scanner;

public class SimpleCalculator {
	
public SimpleCalculator() {
	
	
}
	public static void main(String[] args) {
		System.out.println("Вас вітає калькулятор!");
		System.out.println("Яку операцію ви хочере виконати?");
		System.out.println("1. Додавання");
		System.out.println("2. Віднімання");
		System.out.println("3. Множення");
		System.out.println("4. Ділення");
		int sum;
		Scanner scanner = new Scanner(System.in);
		int operation = scanner.nextInt();
		System.out.println("Напишіть перше число");
		int number1 = scanner.nextInt();
		System.out.println("Напишіть друге число");
		int number2 = scanner.nextInt();
		if (operation == 1) {
			sum = number1 + number2;	
			System.out.println("Результат = " + sum);
		}
		else if (operation == 2) {
			sum = number1 - number2;	
			System.out.println("Результат = " + sum);
		}
		else if (operation == 3) {
			sum = number1 * number2;	
			System.out.println("Результат = " + sum);
		}
		else if (operation == 4) {
			sum = number1 / number2;
			System.out.println("Результат = " + sum);
		}
		else {
			System.out.println("Вибрана не допустима операція");
		}
	}

}

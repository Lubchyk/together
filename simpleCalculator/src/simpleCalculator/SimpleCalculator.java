package simpleCalculator;

import java.util.Scanner;

public class SimpleCalculator {
	
public SimpleCalculator() {
	
	
}
	public static void main(String[] args) {
		System.out.println("��� ��� �����������!");
		System.out.println("��� �������� �� ������ ��������?");
		System.out.println("1. ���������");
		System.out.println("2. ³�������");
		System.out.println("3. ��������");
		System.out.println("4. ĳ�����");
		int sum;
		Scanner scanner = new Scanner(System.in);
		int operation = scanner.nextInt();
		System.out.println("�������� ����� �����");
		int number1 = scanner.nextInt();
		System.out.println("�������� ����� �����");
		int number2 = scanner.nextInt();
		if (operation == 1) {
			sum = number1 + number2;	
			System.out.println("��������� = " + sum);
		}
		else if (operation == 2) {
			sum = number1 - number2;	
			System.out.println("��������� = " + sum);
		}
		else if (operation == 3) {
			sum = number1 * number2;	
			System.out.println("��������� = " + sum);
		}
		else if (operation == 4) {
			sum = number1 / number2;
			System.out.println("��������� = " + sum);
		}
		else {
			System.out.println("������� �� ��������� ��������");
		}
	}

}

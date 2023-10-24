package october.woche2.tag2;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Aufgabe2 {

	public static void main(String[] args) {
		
		System.out.println("*** Taschenrechner ***");
		
		char repeat = 'j';
		
		while( repeat=='j' ) {
			System.out.print("1. Zahl: ");
			double a = readUserNumber();
			
			System.out.print("Operator (+, -, *, /): ");
			char operator = readUserChar();
			
			System.out.print("2. Zahl: ");
			double b = readUserNumber();
			
			BiFunction<Double, Double, Double> op = null;
			
			switch (operator) {
				case '+':
					op = (n1, n2) -> n1 + n2;
					break;
				case '-':
					op = (n1, n2) -> n1 - n2;
					break;
				case '*':
					op = (n1, n2) -> n1 * n2;
					break;
				case '/':
					op = (n1, n2) -> n1 / n2;
					break;
	
				default:
					System.out.println("Fehler! Operator nicht unterstützt: " + operator);
					continue; // wieder von vorne nach einem Fehler
			}
			
			double result = op.apply(a, b);
			System.out.println("Ergebnis: " + result);
			
			System.out.print("Nochmal? (j/n): ");
			repeat = readUserChar();
		}
		
	}
	
	@SuppressWarnings("resource")
	private static double readUserNumber() {
		return new Scanner(System.in).nextDouble();
	}
	
	@SuppressWarnings("resource")
	private static char readUserChar() {
		return new Scanner(System.in).nextLine().charAt(0);
	}
}
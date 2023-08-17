package august.woche3.tag4;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryOperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnaryOperator<Integer> op1 = (Integer) -> {return 42;};
		
		BinaryOperator<Integer> op2 = (Integer p1, Integer p2) -> {
			return 42;
		};
		
		

	}

}

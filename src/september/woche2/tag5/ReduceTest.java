package september.woche2.tag5;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {

	public static void main(String[] args) {

		
		Integer[] array = {1,2,3,4};
		
		BinaryOperator<Integer> acc = (a,b) -> a -b;
		
		Integer i = Arrays.stream(array)
			.parallel()
			.reduce(0, acc);
		
		System.out.println(i);
		

		
		
	}

}

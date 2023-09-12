package september.woche2.tag4;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class reduceExample {

	public static void main(String[] args) {

		Integer[] array = {1,2,3,4,5,6};
		
		
		/*
		 * Optional<T> reduce(BinaryOperator<T> accumulator);
		 * public interface BiFunction<T, U, R>
		 * R apply(T t, U u);
		 * 
		 */
		
		BinaryOperator<Integer> acc = (Integer a, Integer b) -> a + b;
		
		Optional<Integer> maybeSum =  Arrays.stream(array)
			.reduce(acc);
		
		System.out.println(maybeSum.get());
		
		kleineAufgabe();
		
	}
	
	static void kleineAufgabe() {
		Integer[] array = {100,-3,15,4, -15};
		
		Optional<Integer> min =  Arrays.stream(array)
			.reduce((a,b) -> a < b ? a : b);
		
		Optional<Integer> min2 =  Arrays.stream(array)
				.reduce((a,b) -> Math.min(a, b));
		
		Optional<Integer> min3 =  Arrays.stream(array)
				.reduce(Math::min);

		BinaryOperator<Integer> acc = Math::min;
		Optional<Integer> min4 =  Arrays.stream(array)
				.reduce(acc);
		
		
		System.out.println(min.get());
		System.out.println(min2.get());
		System.out.println(min3.get());
		System.out.println(min4.get());
	}

}

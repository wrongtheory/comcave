package september.woche2.tag4;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class reduceExample2 {

	public static void main(String[] args) {
		
		Integer[] array = {1,2,3,4,5};
		
		/*
		 *  T reduce(T identity, BinaryOperator<T> accumulator);
		 *  public interface BiFunction<T, U, R>
		 *  R apply(T t, U u);

		 */
		
		Integer max1 =  Arrays.stream(array)
			.reduce(0, Math::max);
		
		System.out.println(max1);
	}

}

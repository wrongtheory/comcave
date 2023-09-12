package september.woche2.tag4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class reduceExample3 {

	public static void main(String[] args) {
		
		Integer[] array = {1,2,3,4,5};
		
		/*
		 * <U> U reduce(U identity,
         *        BiFunction<U, ? super T, U> accumulator,
         *        BinaryOperator<U> combiner);
                 
           public interface BiFunction<T, U, R>
           R apply(T t, U u);
           
           public interface BiFunction<T, U, R>
            R apply(T t, U u);
		 */
		
		Integer identity = 0;
		
		BiFunction<Integer, Integer, Integer> acc = (a,b) -> a + b;
		
		BinaryOperator<Integer> combiner = (a,b) -> a  + b;
		
		Integer sum = Stream.of(array)
			.parallel()
			.reduce(identity, acc, combiner);

		
		System.out.println(sum);
	}

}

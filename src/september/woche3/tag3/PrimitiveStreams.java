package september.woche3.tag3;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

	public static void main(String[] args) {

		
		IntStream s1;
		LongStream s2;
		DoubleStream s3;
		
		Integer[] arr1 = {1,2,3};
		
		Predicate<Integer> p1 = (Integer x) -> {
			return x.intValue() > 0;
		};
		
		Function<Integer, Integer> f1 = (Integer x)->{
			return Integer.valueOf(x.intValue() + 1);
		};
		
		Stream.of(arr1).filter(x -> x > 0).map(x -> x + 1);
		
		
		
		
		int[] arr2 = {1,2,3};
		
		IntPredicate p2 = x -> {
			return x > 0;
		};
		
		IntUnaryOperator f2 = x -> {
			return x + 1;
		};
		
		IntStream.of(arr2).filter(p2).map(f2);

		
		
	}

}

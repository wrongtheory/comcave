package september.woche2.tag1;

import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class KleineAufgabeInitStream {

	public static void main(String[] args) {
		
		System.out.println("\n** 1\n");
		
		Supplier<Integer> sup = () -> (int)Math.random();
		
		Stream.generate(() -> new Random().nextInt(100))
			.limit(10)
			.forEach(System.out::println);
		
		System.out.println("\n** 2\n");

		
		Stream.iterate(5.1f, x -> x - 1)
			.limit(4)
			.forEach(x -> System.out.println(x));
		
		System.out.println("\n** 3\n");
		
		Integer[] arr = {1,2};
		
		Stream.of(arr)
			.forEach(x -> System.out.println("moin" + x));
		
		Stream.<Integer[]>of(arr)
			.forEach(x -> System.out.println(arr));
		
		System.out.println("\n** 4\n");
		
		
		
		
		

	}

}

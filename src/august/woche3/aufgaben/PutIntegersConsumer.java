package august.woche3.aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PutIntegersConsumer {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		putIntegers(i -> sb.append(i).append(" "));
		System.out.println(sb);

		List<Integer> list = new ArrayList<>();
		putIntegers(i -> list.add(i));
		System.out.println(list);

		putIntegers(System.out::print);

	}

	public static void putIntegers(Consumer<Integer> cons) {
		
//		for(int i = 1; i<=4; i++)
//			cons.accept(i);
		
//		for(int i = 1; i<=4; i++)
//			cons.apply(i);
		
// 		Stream.iterate(1, n -> n+1).limit(4).forEach(cons);

		 Stream.of(1,2,3,4).forEach(cons);

	}

}

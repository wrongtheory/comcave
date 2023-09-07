package september.woche2.tag3;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForEachOrderedExample {

	public static void main(String[] args) {
		
		
		Consumer<Integer> c1 = x -> {
			System.out.println(x + " ");
		};
		
		/*
		 * void forEach(Consumer<? super T> action);
		 * public interface Consumer<T>
		 * void accept(T t);
		 */
		
		Stream.of(1,2,3,4,5,6)
			.parallel()
			.forEach(c1);
		
		
		System.out.println();
		
		/*
		 *  void forEachOrdered(Consumer<? super T> action);
		 *  public interface Consumer<T>
		 *  void accept(T t);
		 */
		
		Stream.of(1,2,3,4,5,6)
			.parallel()
			.map(x -> x + 1)
			.forEachOrdered(c1);
		
		System.out.println();
		
		long count1 = Stream.iterate(1, x -> x + 1)
							.peek(x -> System.out.println(x))
							.limit(5)
							.count();
		
		System.out.println(count1);
		

	}

}

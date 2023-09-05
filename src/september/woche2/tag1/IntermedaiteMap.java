package september.woche2.tag1;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Stream;

public class IntermedaiteMap {

	public static void main(String[] args) {
		
		/*
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		 * public interface Function<T, R>
		 * R apply(T t);
		 *
		 */
		
		Function<String, Integer> f1 = s -> s.length();
		
		Stream.of("a","bb","ccc","dddd")
			.map(f1)
			.forEach(x -> System.out.println(x));
		
		kleineAufgabe();

	}
	
	static void kleineAufgabe() {
		Stream.iterate(2000, x -> x  + 1)
			.limit(4)
			.map(x -> LocalDate.of(x, 1, 1))
			.map(x -> x.getYear())
			.forEach(x -> System.out.println(x));
	}

}

package september.woche2.tag1;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {
		
		/*
		 * Stream<T> filter(Predicate<? super T> predicate);
		 * public interface Predicate<T>
		 * boolean test(T t);
		 * 
		 */
		
		Predicate<Integer> istGerade = x -> x % 2 == 0;
		
		Stream.of(12,77,3,6,11,40)
		.filter(istGerade)
			.forEach(x -> System.out.println(x));
		
		kleineAufgabe();

	}
	
	static void kleineAufgabe() {
		String[] array = {"mo","Dienstag","mi","Donnerstag","fr"};
		
		Arrays.stream(array)
			.filter(x -> x.length() <= 2)
			.forEach(x -> System.out.println(x));
	}

}

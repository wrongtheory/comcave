package september.woche2.tag3;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class AllMatch_AnyMatch_NoneMatch {

	public static void main(String[] args) {

	
		Integer[] array = {12,1000,77,13};
		
		/*
		 * boolean allMatch(Predicate<? super T> predicate);
		 * public interface Predicate<T> 
		 * boolean test(T t);
		 */
		
		boolean result = Stream.of(array)
			.allMatch(x -> x >0);
			
		System.out.println("All positive? " + result);
		
		result = Stream.of(array)
				.allMatch(x -> x < 0);
		
		System.out.println("All negative? " + result);
		
		
		boolean b = Stream.<Integer>empty()
			.allMatch(x->x>0);

		System.out.println(b);
		
		/*
		 * boolean anyMatch(Predicate<? super T> predicate);
		 * public interface Predicate<T> 
		 * boolean test(T t);
		 */

		
		result = Stream.of(array).anyMatch(x-> x > 100);
		System.out.println("any elemenet > 100: " + result);
		
		result = Stream.of(array).anyMatch(x-> x < 0);
		System.out.println("any elemenet < 0: " + result);
		
		b = Stream.<Integer>empty()
				.anyMatch(x->x<0);

			System.out.println(b);
			
			
		/*
			 * boolean noneMatch(Predicate<? super T> predicate);
			 * public interface Predicate<T> 
			 * boolean test(T t);
		*/
			
			
		result = Stream.of(array).noneMatch(x-> x > 100);
		System.out.println("none elemenet > 100: " + result);
	
		result = Stream.of(array).noneMatch(x-> x < 0);
		System.out.println("none elemenet < 0: " + result);

		b = Stream.<Integer>empty()
				.noneMatch(x->x<0);

		System.out.println(b);


	}

}

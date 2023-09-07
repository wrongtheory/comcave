package september.woche2.tag3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstFindAny {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10,20,30,40,50);
		
		/*
		 * Optional<T> findFirst();
		 */
		
		Optional<Integer> findFirst =  list.stream().findFirst();
		
		System.out.println("find first element: " + findFirst.get());
		
		/*
		 * Optional<T> findAny();
		 */
	
		
		Optional<Integer> findAny =  list.stream().findAny();
		
		System.out.println("find any element: " + findAny.get());
	}

}

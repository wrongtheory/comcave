package august.woche5.tag3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class GenericAufgabe {

	public static void main(String[] args) {
		
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
	    Predicate<Integer> isEven = i -> i % 2 == 0;
	    System.out.println( count(list1, isEven) ); // 2

	    Predicate<Number> isOdd = b -> b.intValue() % 2 != 0;
	    List<Number> list2 = Arrays.asList(1, 1.2, 3, 3.4);
	    System.out.println( count(list2, isOdd) ); // 4

	    Predicate<String> isEmpty = String::isEmpty;
	    List<String> list3 = Arrays.asList("a", "", "b", "", "c");
	    System.out.println( count(list3, isEmpty) ); // 2
	    
	    //count(list1, isEmpty);

	    
	}
	
	
	public static <T extends Object> Integer count(List<T> list, Predicate<T> predicate) {
		Integer count = 0;
		
		for(T element : list)
			if(predicate.test(element))
				count++;
		
		return count;
	}

}

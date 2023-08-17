package august.woche2.tag3.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateFunction {

	public static void main(String[] args) {
		
		Predicate<Integer> p1 = new Predicate<Integer>() {
			public boolean test(Integer x) {
				return x > 0;
			}
		};
		
		System.out.println(p1.test(12));
		
		Predicate<Integer> p2 = (Integer x) -> {
			return x > 0;
		};
		
		System.out.println(p2.test(12));
		
		Predicate<Integer> p3 = x -> x > 0;
		System.out.println(p3.test(2));
		
	}

}

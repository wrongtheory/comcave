package august.woche3.tag4;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		
		Function<String, Integer> f1 = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		
		System.out.println(f1.apply("Moin"));
		
		Function<String, Integer> f2 = (String s) -> {return s.length();};
		System.out.println(f2.apply("moin"));
		
		Function<String, Integer> f3 = s -> s.length();
		
		System.out.println(f3.apply("moin"));

	}

}

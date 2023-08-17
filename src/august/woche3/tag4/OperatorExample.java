package august.woche3.tag4;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnaryOperator<String> uo1 = new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		
		System.out.println(uo1.apply("moin"));
		
		UnaryOperator<String> uo2 = (String s) -> {return s.toUpperCase();};
		
		Function<String, String> tmp = null;
		tmp = uo1;
		
		System.out.println(tmp.apply("hello"));
		
		UnaryOperator<String> uo3 = s -> s.toUpperCase();
		System.out.println(uo3.apply("yuhu"));
	}

}

package september.woche2.tag4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.Function;

public class ComparatorErzeugen {

	public static void main(String[] args) {

		class MyComparator implements Comparator<Locale> {
			public int compare(Locale a, Locale b) {
				return a.getDisplayCountry().compareTo(b.getDisplayCountry());
			}
		}
		
		new Comparator<Locale>() {
			public int compare(Locale a, Locale b) {
				return a.getDisplayCountry().compareTo(b.getDisplayCountry());
			}

		};
		
		Comparator<Locale> cmp1 = (Locale a, Locale b) -> {
			return a.getDisplayCountry().compareTo(b.getDisplayCountry());
		};
		
		Comparator<Locale> cmp2 = (a,b) -> a.getDisplayCountry().compareTo(b.getDisplayCountry());
		
	
		
		Collections.reverseOrder();
		
		Function<Locale, String> keyExtractor = loc -> loc.getDisplayCountry();
		
		
		Comparator<Locale> cmp3 =  Comparator.comparing(keyExtractor);
		
		Locale a = new Locale("de","DE");
		Locale b = new Locale("it","IT");
		
		System.out.println(keyExtractor.apply(a));
		System.out.println(keyExtractor.apply(b));
		
		String s1 = keyExtractor.apply(a);
		String s2 = keyExtractor.apply(b);
		
		System.out.println(s1.compareTo(s2));
		
		System.out.println(cmp3.compare(a, b));


	}// main
	

}


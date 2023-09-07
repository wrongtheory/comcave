package september.woche2.tag3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class Aufgabe {

	public static void main(String[] args) {

		Locale[] locales = Locale.getAvailableLocales();

		System.out.println("*********A1***********************************");
		
		Optional<String> maxLocale =  Stream.of(locales)
			.map(x -> x.getDisplayCountry())
			.max((o1, o2) -> o1.length()-o2.length());

		if(maxLocale.isPresent())
			System.out.println("Max Locale (mit Stream): " + maxLocale.get());
		
		System.out.println("*********A2***********************************");
		
		long deLanguage = Stream.of(locales)
				.filter(x -> x.getLanguage().equals("de"))
				.count();
		
		System.out.println("Count 'DE' Sprache (mit Stream): " + deLanguage);
		
		System.out.println("*********A3***********************************");
		
		 // A    
		List<Locale> filtered = new ArrayList<>();
		for (Locale locale : locales) {
		    if(locale.getDisplayCountry().contains("t")) {
		        filtered.add(locale);
		    }
		}

		Comparator<Locale> cmp = (loc1, loc2) -> 
		        loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());

		filtered.sort( cmp );

		Locale min = null;
		if(filtered.size() > 0) {
		    min = filtered.get( 0 );
		}
		// B
		
		System.out.println("Country and Language (ohne stream): " + min);
		
		Optional<Locale> countryLanguage = Arrays.stream(locales)
			.filter(x -> x.getDisplayCountry().contains("t"))
			.min((a,b) -> a.getDisplayLanguage().compareTo(b.getDisplayLanguage()));
		
		
		System.out.println("Country and Language (mit Stream): " + countryLanguage.get());
		
		
	}

}

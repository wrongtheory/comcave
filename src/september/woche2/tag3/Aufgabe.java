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
		
		Optional<Locale> maxLocale =  Stream.of(locales)
			//.map(x -> x.getDisplayCountry())
			.max((o1, o2) -> o1.getDisplayCountry().compareTo(o2.getDisplayCountry()));
		
		Optional<Locale> maxLocale2 =  Stream.of(locales)
				//.map(x -> x.getDisplayCountry())
				.max((o1, o2) -> o1.getDisplayCountry().compareTo(o2.getDisplayCountry()));
		
		Optional<String> maxLocale3 =  Stream.of(locales)
				.map(x -> x.getDisplayCountry())
				.max((o1, o2) -> o1.compareTo(o2));
		
		Comparator<Locale> cmp2 = (Locale a,Locale b) -> {
			String loc1 = a.getDisplayCountry();
			String loc2 = b.getDisplayCountry();
			return loc1.compareTo(loc2);
		};


		Optional<Locale> maxLocale4 = Stream.of(locales)
					.max(cmp2);

		if(maxLocale.isPresent())
			System.out.println("Max Locale (mit Stream): " + maxLocale.get());
		
		if(maxLocale2.isPresent())
			System.out.println("Max Locale (mit Stream): " + maxLocale2.get());
		
		if(maxLocale3.isPresent())
			System.out.println("Max Locale (mit Stream): " + maxLocale3.get());
		
		if(maxLocale4.isPresent()) {
			Locale loc = maxLocale4.get();
			System.out.println("Max Locale (mit Stream): " + loc);
			System.out.println(loc.getCountry());
			System.out.println(loc.getDisplayCountry(loc));
			System.out.println(loc.getLanguage());
			System.out.println(loc.getDisplayLanguage());
			System.out.println(loc.getDisplayName());
			}


		
		System.out.println("*********A2***********************************");
		
		long deLanguage = Stream.of(locales)
				.filter(x -> x.getLanguage().equals("de"))
				.peek(x -> System.out.println(x.getDisplayCountry()))
				.count();
		
		System.out.println("Count 'DE' Sprache (mit Stream): " + deLanguage);
		
		System.out.println("*********A3***********************************");
		
		 // A    
		List<Locale> filtered = new ArrayList<>();
		for (Locale locale : locales) {
		    if(locale.getDisplayCountry().contains("T")) {
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
			.peek(x -> System.out.println(x))
			.filter(x -> x.getDisplayCountry().contains("T"))
			.min((a,b) -> a.getDisplayLanguage().compareTo(b.getDisplayLanguage()));
		
		
		System.out.println("Country and Language (mit Stream): " + countryLanguage.get());
		
		
	}

}

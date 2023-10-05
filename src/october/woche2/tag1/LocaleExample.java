package october.woche2.tag1;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;

public class LocaleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Locale loc = Locale.getDefault();
		System.out.println(loc);
		
		Locale.setDefault(Locale.UK);
		System.out.println(loc);
		
		ZonedDateTime ldt = ZonedDateTime.now();
		System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)));
		
		Arrays.stream(Locale.getAvailableLocales()).filter(x -> x.toString().startsWith("ro")).forEach(System.out::println);
		
		

	}

}

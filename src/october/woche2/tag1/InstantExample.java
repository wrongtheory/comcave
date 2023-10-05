package october.woche2.tag1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class InstantExample {

	private static Object object;

	public static void main(String[] args) {
		
		
		Instant instant = Instant.now();
		
		System.out.println("Instant: " + instant);
		
		long sek = instant.getEpochSecond();
		
		System.out.println("sek: " + sek);
		
		System.out.printf("sek: %,d%n", sek);
		long millis = instant.toEpochMilli();
		System.out.println("millis: " + millis);
		System.out.printf("millis: %,d%n", millis);
		instant.truncatedTo(ChronoUnit.DAYS);
		System.out.println("instant: " + instant);
		instant  = instant.truncatedTo(ChronoUnit.DAYS);
		System.out.println(instant);
		
		
		ZonedDateTime ldt = ZonedDateTime.now();
		System.out.println(ldt);
		
		ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL));
		
		

	}

}

package october.woche2.tag1;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Aufgabe {

	public static void main(String[] args) {
		
		System.out.println("***********************A1***********************");
		a1();
		System.out.println("***********************A2***********************");
		a2();
		System.out.println("***********************A3***********************");
		a3();
	}
	
	private static void a1() {
		//DateTimeFormatter dtf =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM);
		
		// 12:00 [UTC+01:00]  // 11:00 
		// 16:00 [UTC+02:00]  // 14:00
		// Dauer: 3 Stunden
		
		ZonedDateTime zdt1 = ZonedDateTime.of(LocalDate.now(), LocalTime.parse("12:00"), ZoneId.of("UTC+1"));
		ZonedDateTime zdt2 = ZonedDateTime.of(LocalDate.now(), LocalTime.parse("16:00"), ZoneId.of("UTC+2"));
		
		System.out.println("Start Reise: " + zdt1);
		System.out.println("Ende Reise: " + zdt2);
		
		long reise = ChronoUnit.HOURS.between(zdt1,zdt2);
		
		System.out.println("Die Reise dauert " + reise + " hours");
	}
	
	private static void a2() {
		ZonedDateTime startReise = ZonedDateTime.of(LocalDate.now(), LocalTime.of(8,00), ZoneId.of("UTC+2"));
		
		Duration dauerReise = Duration.ofHours(3);
		
		ZonedDateTime ankunft = startReise.plus(dauerReise);
		
		ankunft = ankunft.withZoneSameInstant(ZoneId.of("UTC+1"));
		
		System.out.println("Start Reise: " + startReise);
		System.out.println("Dauer der Reise: " + dauerReise.toHours() + " hours");
		System.out.println("Ankunft    : " + ankunft);
	}
	
	private static void a3() {
		ZonedDateTime beforeDaylightSaving = ZonedDateTime.of(LocalDate.of(2018,Month.MARCH,25), LocalTime.of(1, 00) , ZoneId.of("Europe/Berlin"));
		ZonedDateTime afterDaylightSaving  = ZonedDateTime.of(LocalDate.of(2018,Month.MARCH,25), LocalTime.of(4, 00) , ZoneId.of("Europe/Berlin"));

//		Wechsel von Normalzeit auf Sommerzeit am 25.03.2018 von 01:59:59 Uhr auf 03:00:00 Uhr
//      Am 25 MARCH 2018 '2:00' Uhr gab es nicht => 4 - 1 - 1 = 2 Stunden
		
		Duration dauerBetweenDayLightSaving = Duration.between(beforeDaylightSaving, afterDaylightSaving);
		System.out.println("Am 25. März 2018 in Berlin zwischen 01:00 Uhr nachts und 04:00 Uhr nachts"
				+ " sind " + dauerBetweenDayLightSaving.toHours() + " Stunden vergangen");
	}
}

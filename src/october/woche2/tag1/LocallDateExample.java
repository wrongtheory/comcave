package october.woche2.tag1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class LocallDateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		ZonedDateTime zonedNow = ZonedDateTime.now();
		System.out.println(zonedNow);
		
		ZonedDateTime zonedLA = ZonedDateTime.of(now2, ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedLA);

		//ZoneId.getAvailableZoneIds().forEach(System.out::println);
		
		// Startzeit 11:30 ab Frankfurt, Flugdauer 17:30 Stunden, Ankunft in Los Angeles
		
		ZonedDateTime start = ZonedDateTime.of(2023,10,4,11,30,0,0, ZoneId.systemDefault());
		System.out.println("Abflug in Frankfurt: " + start);
		
		Duration dauerFlug = Duration.ofHours(17).plusMinutes(30);
		System.out.println(dauerFlug);
		
		ZonedDateTime ankunft = start.plus(dauerFlug);
		ankunft = ankunft.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		
		System.out.println("Ankunft: " + ankunft);
		
		//Startzeit: heute 20:00 Uhr ab Dusseldorf, Ankunft in Bangkok 14:40 Ortszeit
		
		ZonedDateTime startD = ZonedDateTime.of(LocalDate.now(), LocalTime.parse("20:00"), ZoneId.of("Europe/Berlin"));
		
		ZonedDateTime ankunftB = ZonedDateTime.of(LocalDate.now().plus(1, ChronoUnit.DAYS),LocalTime.of(14, 40), ZoneId.of("Asia/Bangkok"));
		
		System.out.println("start Dusseldorf: " + startD.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT)));
		System.out.println("Ankunft Bangkok: " + ankunftB);
		
		Duration duration = Duration.between(startD, ankunftB);
		System.out.println(duration.toHours() + " hours " + duration.toMinutes() % 60 + " minutes ");
		
		
		startD = ZonedDateTime.of(LocalDate.now(), LocalTime.parse("20:00"), ZoneId.of("UTC+2"));
		ankunftB = ZonedDateTime.of(LocalDate.now().plus(1, ChronoUnit.DAYS),LocalTime.of(14, 40), ZoneId.of("UTC+7"));
		
		
		System.out.println("start Dusseldorf: " + startD.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT)));
		System.out.println("Ankunft Bangkok: " + ankunftB);

		
		duration = Duration.between(startD, ankunftB);
		System.out.println(duration.toHours() + " hours " + duration.toMinutes() % 60 + " minutes ");
		
		
		System.out.println(ZoneId.systemDefault().getRules().getTransitionRules());
		
		ZonedDateTime beforeDayLightSaving = ZonedDateTime.of(LocalDate.parse("2023-03-26"), LocalTime.of(1, 55), ZoneId.of("Europe/Rome"));
		
		System.out.println(beforeDayLightSaving.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.FULL)));
		
		beforeDayLightSaving = beforeDayLightSaving.plusHours(1);
		
		System.out.println(beforeDayLightSaving.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.FULL)));
	
		beforeDayLightSaving = ZonedDateTime.of(LocalDate.parse("2023-10-29"), LocalTime.of(2, 55), ZoneId.of("Europe/Rome"));
		ZonedDateTime afterDayLightSaving = ZonedDateTime.of(LocalDate.parse("2023-10-29"), LocalTime.of(3, 55), ZoneId.of("Europe/Rome"));
		Duration dauer = Duration.between(beforeDayLightSaving, afterDayLightSaving);
		
		System.out.println("Dauer in stunden: " + dauer.toHours());
		
		long anzahl =  ChronoUnit.HOURS.between(beforeDayLightSaving, afterDayLightSaving);
		
		System.out.println("Anzahl: " + anzahl);
		
		// 
		
		//Duration dur = Duration.between(LocalDate.parse("1900-01-01"), LocalDate.parse("1999-12-31"));
		//System.out.println(dur);
		
		//Period p = LocalDate.of(2000, 01, 01).until(now);
		//System.out.println(p.getYears()*24*24);
		//Duration.between(LocalDate.of(2000, 1, 1), LocalDate.now().of(2023, 10, 4));
		
		long days =  ChronoUnit.DAYS.between(LocalDate.of(1900, 1, 1), LocalDate.parse("1999-12-31"));
		
		System.out.println(days);
		
		
	}

}

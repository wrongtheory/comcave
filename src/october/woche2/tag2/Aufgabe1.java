package october.woche2.tag2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Aufgabe1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Locale.setDefault(Locale.ITALIAN);
		
		ResourceBundle bundle = ResourceBundle.getBundle("october.woche2.tag2.lan");
		
		Locale loc = Locale.getDefault().getLanguage().equals("en") ? Locale.ENGLISH : Locale.GERMAN;
		loc.setDefault(loc);
		
		
		LocalDate now = LocalDate.now();
		System.out.println(bundle.getString("label.date") + now.format(DateTimeFormatter.ofPattern(bundle.getString("format.pattern"))));
		System.out.println(bundle.getString("label.weekday") + now.format(DateTimeFormatter.ofPattern("eeee")));
		
		Properties p = System.getProperties();
		String name = p.getProperty("user.name");
		System.out.println(bundle.getString("label.hello") + " " + name);
		
		//p.setProperty("user.birthday", "2023-10-07");
		String birthday = p.getProperty("user.birthday");
		if(birthday != null) {
			LocalDate birthdayAsDate = LocalDate.parse(birthday);
			long days = ChronoUnit.DAYS.between(now, birthdayAsDate);
			System.out.println("days: " + days);
		}
		
		
		if(birthday == null) {
			Properties p2 = new Properties();
			p2.load(new FileReader("props"));
			birthday = p2.getProperty("user.birthday");
			LocalDate birthdayAsDate = LocalDate.parse(birthday);
			long days = ChronoUnit.DAYS.between(now, birthdayAsDate);
			System.out.println("Es sind noch " + days + " days bis zum geburtstag");

		}
	}

}

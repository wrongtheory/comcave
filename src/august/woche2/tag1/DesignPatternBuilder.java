package august.woche2.tag1;

import java.util.Locale;

public class DesignPatternBuilder {

	public static void main(String[] args) {
		
		String sb = new StringBuilder()
			.append("Heute")
			.append(" war ")
			.append("Montag")
			.toString();
		
		System.out.println(sb);
		
		Locale loc = new Locale.Builder()
			.setLanguage("DE")
			.build();
		
		System.out.println(loc);

	}

}

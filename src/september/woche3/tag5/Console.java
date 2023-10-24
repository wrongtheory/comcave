package september.woche3.tag5;

import java.util.Arrays;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.io.Console c = System.console();
		System.out.println(c);
		
		
		
		c.format("Heute ist %s!%n", "Freitag");
		c.printf("Gestern war %s!%n", "Donnerstag");
		
		c.format("Namen eingeben: ");
		
		String line = c.readLine();
		
		c.format("Gelesen: %s%n", line);
		
		char[] pwd = c.readPassword("Passwort eingeben: ");
		c.format("Gelesen: %s", Arrays.toString(pwd));


	}

}

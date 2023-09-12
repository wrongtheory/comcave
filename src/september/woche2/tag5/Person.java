package september.woche2.tag5;

import java.util.Comparator;

public class Person {
	
	private String vorname;
	private String nachname;
	
	public Person(String firstname, String lastname) {
		this.vorname = firstname;
		this.nachname = lastname;
	}
	
	@Override
	public String toString() {
		return vorname + " " + nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}	
}

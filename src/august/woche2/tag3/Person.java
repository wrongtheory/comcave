package august.woche2.tag3;

public class Person {
	
	private String vorname, nachname;
	private int geburtsjahr;
	
	
	public Person(String vorname, String nachname, int geburtsjahr) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}

	

	public String getVorname() {
		return vorname;
	}



	public void setVorname(String vorname) {
		this.vorname = vorname;
	}



	public String getNachname() {
		return nachname;
	}



	public void setNachname(String nachname) {
		this.nachname = nachname;
	}



	public int getGeburtsjahr() {
		return geburtsjahr;
	}



	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}



	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname + ", geburtsjahr=" + geburtsjahr + "]";
	}

	

}

package august.woche3.aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person {

	String vorname;
	String nachname;
	int geburtsjahr;

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

class GeburtsJahrTesten implements Predicate<Person>{
	int jahr;
	
	public GeburtsJahrTesten(int jahr) {
		this.jahr = jahr;
	}
	public boolean test(Person p) {
		return p.getGeburtsjahr() > 1965;
	}


}

public class Test {

	static class NachNameTesten implements Predicate<Person>{
		String substr;
		
		public NachNameTesten(String str) {
			this.substr =str;
		}
		
		public boolean test(Person p) {
			return p.getNachname().contains("a");
		}

	} // end NachNameTesten (InnereKlasse)

	

	public static void main(String[] args) {
		Person[] persons = {
				new Person("Vasea", "Mar", 1980),
				new Person("Elton", "John", 1965),
				new Person("Elon", "Musk", 1972),
				new Person("John", "Travolta", 1955)
		};

		System.out.println("<<--Initial array: ");
		List<Person> list = filtern(persons, p -> true);

//		for (Person p : persons)
//			System.out.println(p);
		print(list);

		System.out.println("\n<<--Personen gebohren nach dem 1965 Jahr: ");
		Predicate<Person> p3 = new GeburtsJahrTesten(1965);
		list = filtern(persons, p3);
		print(list);

		System.out.println("\n<<--Personen die in Ihren Nachname mindestens einen 'a' haben: ");
		Predicate<Person> p4 = new NachNameTesten("a");
		list = filtern(persons, p4);
		print(list);

		

		System.out.println("\n<<--Personen die in Ihren Nachname mindestens 4 Zeichen haben: ");

		new Test().getNachname4Zeichen();
		for (Person p : list)
			System.out.println(p);

		System.out.println("\n<<--Zwei Filter: jahr > 1965 and Nachname contains 'a'");

		Predicate<Person> pred = new Predicate<Person>() {
			Predicate<Person> p = p -> p.getGeburtsjahr() > 1965;
			Predicate<Person> q = q -> q.getNachname().contains("a");

			@Override
			public boolean test(Person t) {
				return p.and(q).test(t);
			}

		};

		filtern(persons, pred);
		for (Person p : list)
			System.out.println(p);

	} // end main Methode

	public void getNachname4Zeichen() {
		class NachNameLocalTesten {
			Predicate<Person> p = p -> p.getNachname().length() >= 4;

//			public NachNameLocalTesten() {
//				Test.filtern(persons, p);
//			}

		}
		new NachNameLocalTesten();
	}
	
	public static void print(List<Person> list) {
		for (Person p : list)
			System.out.println(p);
	}

	static List<Person> filtern(Person[] person, Predicate<Person> filer) {
		List<Person> list = new ArrayList<>();
		for (Person p : person) {
			if (filer.test(p))
				list.add(p);
		}
		return list;
	}


} // end Klasse Test

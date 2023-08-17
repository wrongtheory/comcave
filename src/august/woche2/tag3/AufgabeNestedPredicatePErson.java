package august.woche2.tag3;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class PredicatePersonGeborenNach1975 implements Predicate<Person> {
	int jahr;
	PredicatePersonGeborenNach1975(int jahr){
		this.jahr = jahr;
	}
	public boolean test(Person p) {
		return p.getGeburtsjahr() > jahr;
	}
}

public class AufgabeNestedPredicatePErson {
	
	//innere klasse
	
	static class PredicatePersonMitUnterstringImNachnamen implements Predicate<Person> {
		private String substring;
		private PredicatePersonMitUnterstringImNachnamen(String substring) {
			this.substring = substring;
		}
		public boolean test(Person p) {
			return p.getNachname().contains(substring);
		}
	}

	public static void main(String[] args) {
		
		Person[] array = {
			new Person("Ute", "Mayer", 1980),
			new Person("Paul", "Smith", 1933),
			new Person("John", "Smith", 1971),
			new Person("Ulrike", "Baum", 2004)
		};
		
		System.out.println(" ****** A2. Alle Personen ******");
		
		List<Person> list = filtern(array, p -> true);
		print(list);
		
		System.out.println("\n *** A3. Personen geboren nach 1975");
		Predicate<Person> p3 = new PredicatePersonGeborenNach1975(1975);
		list = filtern(array, p3);
		print(list);
		
		System.out.println("\n *** A4. Personen mit einem 'a' im Nachnamen");
		Predicate<Person> p4 =new PredicatePersonMitUnterstringImNachnamen("m");
		list = filtern(array, p4);
		print(list);
		
		System.out.println("\n *** A5. Personen mit dem Nachnamen langer als 4");
		class PredicatePersonNachnameMindestLange implements Predicate<Person> {
			int minLen;
			private PredicatePersonNachnameMindestLange(int minLen) {
				this.minLen = minLen;
			}
			public boolean test(Person p) {
				return p.getNachname().length() >= minLen;
			}
		}
		Predicate<Person> p5 =new PredicatePersonNachnameMindestLange(5);
		list = filtern(array, p5);
		print(list);
		
		System.out.println("\n *** A6. Personen mit einem 'm' im Nachnamen"
				+ "mit dem Nachnamen langer als 4");
		Predicate<Person> p6 = new Predicate<Person>() {
			
			@Override
			public boolean test(Person t) {
				return p4.and(p5).test(t);
			}
		};
		list = filtern(array, p6);
		print(list);
		
		System.out.println("\nPunkt 6 mit einer Lambda");
		list = filtern(array, p -> p4.and(p5).test(p));
		print(list);
		
		System.out.println("\n *** A7. Personen die in einem Schaltjahr geboren wurden: ");
		Predicate<Person> p7 = (Person p) -> {
			return Year.isLeap(p.getGeburtsjahr());
		};
		list = filtern(array, p7);
		print(list);
		
	}// end of main
	
	static void print(List<Person> list) {
		int i = 1;
		for(Person p: list)
			System.out.println(i++ + ". "+ p);
	}
	
	static List<Person> filtern(Person[] array, Predicate<Person> filter) {
		List<Person> list = new ArrayList<>();
		
		for(Person p : array) {
			if(filter.test(p)) {
				list.add(p);
			}
		}
		
		return list;
	}

}//end of AufgabeNestedPredicatePErson

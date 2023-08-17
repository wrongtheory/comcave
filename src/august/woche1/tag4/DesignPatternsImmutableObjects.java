package august.woche1.tag4;

import java.time.LocalDate;

public class DesignPatternsImmutableObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Objekte von Typ String konnen nicht geandert werden
		
		String s1 = "java";
		s1.toUpperCase(); // Achtung Immutable!
		System.out.println("s1 = " +s1); // java
		
		//Dasselbe gilt fur
		// -alle Wrapper-Klassen
		// -alle Klassen aus DateTime
		
		LocalDate d1 = LocalDate.of(2023, 3, 25);
		d1.plusMonths(7); // Achtung Immutable!
		System.out.println(d1.getMonth());
		System.out.println(d1.getMonthValue());

	}

}

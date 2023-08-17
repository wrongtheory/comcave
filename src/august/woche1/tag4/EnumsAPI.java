package august.woche1.tag4;

import java.util.Arrays;

enum Color{
	RED, // statische KOnstante
	GREEN,
	BLUE
}	

public class EnumsAPI {

	public static void main(String[] args) {
		
		// new Color(); // keine neuen Objekte moglich
		
		Color c1 = Color.RED; // zugriff auf statische Konstante
		
		//statische Methode "values"
		//liefert alle Konstante der Enum Klasse in einem Array
		
		Color[] allcolors = Color.values();
		System.out.println(Arrays.toString(allcolors));
		
		//statische MEthode valueOf(String nameDerKonstante)
		Color c2 = Color.valueOf("RED");
		System.out.println("c2: " + c2);
		
		// toString Methode ist uberschrieben
		
		Color c3 = Color.BLUE;
		System.out.println("c3: " + c3);
		
		//String name()
		
		String name = c3.name();
		System.out.println("c3 name: " + name);
		
		//int ordinal()
		
		System.out.println("ordinal fur alle: ");
		for(Color c : Color.values())
			System.out.println(c.name() + " " + c.ordinal());
		
		//jede Enum Klasse implementiert Comparable
		//compareTo testen
		
		System.out.println("RED compareTo Green: " +
			Color.RED.compareTo(Color.GREEN)); // -1
		
		System.out.println("RED compareTo BLUE: " +
				Color.RED.compareTo(Color.BLUE)); // -2
		
		
		
		
		
	}

}

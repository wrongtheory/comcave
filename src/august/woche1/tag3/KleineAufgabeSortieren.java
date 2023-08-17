package august.woche1.tag3;

import java.util.Arrays;
import java.util.Comparator;

class Kreis implements Comparable<Kreis>, Comparator<Kreis>{
	private int radius;
	private String farbe;
	
	public int getRadius() {
		return radius;
	}
	
	public String getFarbe() {
		return farbe;
	}
	
	public Kreis(int radius) {
		this(radius, "rot");
	}
	
	
	public Kreis(int radius, String farbe) {
		this.radius = radius;
		this.farbe = farbe;
	}
	
	public String toString() {
		return "Kreis. R = " + radius + ", Farbe: " + farbe; 
	}
	
	public int compare(Kreis s1, Kreis s2) {
		Comparator<Kreis> c =
				Comparator.comparing(s -> s.getRadius());
		c = c.thenComparing(s -> s.getFarbe());
		return c.compare(s1, s2);
	}

	@Override
	public int compareTo(Kreis o) {
		int i = radius - o.radius;
		if(i == 0)
			i = farbe.compareTo(o.farbe);
		return i;
	};


}

public class KleineAufgabeSortieren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kreis[] array = {
				new Kreis(7),
				new Kreis(33),
				new Kreis(7, "blau"),
				new Kreis(12, "gelb")
		};
		
		// Aufsteigend nach Radius(beim gleichen Radius nach Farbe) sortieren
		
		/*
		 * Comparator<Kreis> c = Comparator.comparing(s -> s.getRadius()); c =
		 * c.thenComparing(s -> s.getFarbe());
		 */
		
		Arrays.sort(array);
	
		for(Kreis k : array)
			System.out.println(k);

	}

}

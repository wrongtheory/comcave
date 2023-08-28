package august.woche4.tag4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Kreis implements Comparable<Kreis>{
	private int radius;

	public Kreis(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return "K(" + radius + ")";
	}

	@Override
	public int compareTo(Kreis o) {
		// TODO Auto-generated method stub
		return radius - o.radius;
	}

}

public class TreeSetMitKreisen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Kreis> set = new TreeSet<>();
		
		set.add(new Kreis(12));
		set.add(new Kreis(12));
		set.add(new Kreis(12));
		
		System.out.println(set.size()); // 1
		
		System.out.println(set);

		set.add(new Kreis(3));
		set.add(new Kreis(15));
		set.add(new Kreis(1));
		
		System.out.println(set.size()); // 4
		
		System.out.println(set);
		
		System.out.println("\nabsteigend");
		
		//Comparator<Kreis> cmp = Comparator.reverseOrder();
		
		Set<Kreis> set2 = new TreeSet<>(Comparator.reverseOrder());
		
		set2.addAll(set);
		
		
		System.out.println(set2);
	}

}

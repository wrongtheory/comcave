package august.woche4.tag3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class TreeSetAufgabe {

	static NavigableSet<Integer> set = new TreeSet<>();
	static Set<Integer> set2 = new TreeSet<>(Comparator.reverseOrder());
	
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		
		while (set.size() != 100)
			set.add(new Random().nextInt(1000));
		
		while (list.size() != 100)
			list.add(new Random().nextInt(10));
		System.out.println(list);

		System.out.println("Set size: " + set.size());
		System.out.println("Set elements: " + set.descendingSet());

		NavigableSet<Integer> sub = set.subSet(800,true,900,true);
		
		System.out.println("Set size: " + sub.size());
		System.out.println("Set elements: " + sub);
		
		while (set2.size() != 100)
			set2.add(new Random().nextInt(0, 1000));
		
		System.out.println("Set2 size: " + set2.size());
		System.out.println("Set elements: " + set2); 
		
		set2.clear();
		for(Integer i : set) {
			if(i<900 && i > 800)
				set2.add(i);
		}
		System.out.println("Set2 size: " + set2.size());
		System.out.println("Set elements: " + set2); 

	}

}

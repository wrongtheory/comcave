package august.woche4.tag4;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetNavigableSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NavigableSet<Integer> set = new TreeSet<>();
		
		set.add(33);
		set.add(33);
		set.add(17);
		set.add(-5);
		set.add(-5);
		set.add(222);
		set.add(222);
		set.add(7);
		set.add(7);
		
		System.out.println("1. set: " + set);
		
		Integer x = set.first();
		System.out.println(x);
		x = set.last();
		System.out.println(x);
		
		Integer key = 0;
		x = set.higher(key);
		
		System.out.println("higher(0): " + x);
		
		x = set.lower(key);
		System.out.println("lower(0): " + x);
		
		System.out.println("floor(7)" + set.floor(7)); // <=
		System.out.println("ceiling(7): " + set.ceiling(7)); // >=
		
		System.out.println("\n set: " + set);
		
		Integer toElement = 33;
		SortedSet<Integer> headSet =  set.headSet(toElement);
		
		System.out.println(headSet);
		
		toElement = 33;
		SortedSet<Integer> headSet2 =  set.headSet(toElement, true);
		
		System.out.println(headSet2);
		
		SortedSet<Integer> tail = set.tailSet(toElement);
		System.out.println(tail);
		
		SortedSet<Integer> sub= set.subSet(7,false,toElement, true);
		System.out.println(sub);
		
		
		set.add(21);
		
		System.out.println(set);
		System.out.println(sub);
		sub.add(10);
		System.out.println(set);
		System.out.println(sub);
		sub.add(9);
		System.out.println(set);
		System.out.println(sub);
		
		
		
		
	}

}

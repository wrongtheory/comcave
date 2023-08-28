package august.woche4.tag3;

import java.util.HashSet;
import java.util.Set;

public class HashSetMitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet<>();
		
		System.out.println("1. " + set);
		
		set.add("mo");
		set.add(new String("mo"));
		set.add("mo");
		
		
		System.out.println("2. " + set.size());
		
		set.add("di");
		set.add("mi");
		
		System.out.println("3. " + set.size());
		
		set.add("do");
		set.add("fr");
		set.add(null);
		set.add(null);
		
		System.out.println("set: " + set);
		
		

	}

}

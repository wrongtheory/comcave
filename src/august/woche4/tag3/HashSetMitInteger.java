package august.woche4.tag3;

import java.util.HashSet;
import java.util.Set;

public class HashSetMitInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> set = new HashSet<>();
		
		
		
		set.add(12);
		set.add(12);
		
		Integer x = 11;
		set.add(x + 1);
		
		System.out.println(Integer.parseInt("12"));
		
		System.out.println("1. size: " + set.size());
		
		set.add(13);
		set.add(14);
		
		System.out.println("3. size: " + set.size());
		
		set.add(-11);
		set.add(17);
		
		for(Integer i : set)
			System.out.println(i);
		
		
		

	}

}

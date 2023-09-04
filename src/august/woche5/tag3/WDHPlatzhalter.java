package august.woche5.tag3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class WDHPlatzhalter {

	public static void main(String[] args) {
		
		Set<Double> setDouble = new LinkedHashSet<>();
		
		setDouble.add(12.3);
		setDouble.add(-1.5);
		setDouble.add(-1.5);
		
		print(setDouble);
		
		LinkedList<Long> listLong = new LinkedList<>();
		
		listLong.add(12L);
		listLong.add(7L);
		listLong.add(-14L);
		
		print(listLong);
		
		Collection<Number> collNum = new ArrayDeque<Number>();
		collNum.add(12);
		collNum.add(1.2);
		collNum.add(12L);
		collNum.add(12f);
		
		print(collNum);
		
		Iterable<Object> it = new ArrayList<>();
		//print(it); // cf


	}
	
	static void print(Collection<? extends Number>  zahlen) {
		System.out.println("Zahlen: ");
		
		for(Number x : zahlen)
			System.out.println(x);
	}

}

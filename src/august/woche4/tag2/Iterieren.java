package august.woche4.tag2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterieren {

	public static void main(String[] args) {
		
		Collection<Integer> coll = new ArrayList<>();
		
		coll.add(12);
		coll.add(13);
		coll.add(14);
		
		System.out.println("** mit foreach_Schleife");
		
		for(Integer x : coll)
			System.out.println(x);
		
		
		System.out.println("** mit Iterator");
		
		Iterator<Integer> it = coll.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		System.out.println("mit method reference");
		coll.forEach(System.out::println);

	}

}

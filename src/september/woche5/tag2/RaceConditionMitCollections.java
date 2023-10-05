package september.woche5.tag2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;

public class RaceConditionMitCollections {

	public static void main(String[] args) {

//		test(new ArrayList<>());
//		test(new LinkedList<>());
//		test(new HashSet<>());
//		test(new TreeSet<>());
//		test(new PriorityQueue<>());
//		test(new Vector<>());
		
		List<Integer> listA =  Collections.synchronizedList(new ArrayList<>());
		test(listA);

		List<Integer> listB =  Collections.synchronizedList(new LinkedList<>());
		test(listB);
		
		
		

	}
	
	static void test(Collection<Integer> coll){
		
		System.out.println("*** test " + coll.getClass());
		
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				coll.add(i);
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("size: " + coll.size());
		
	}

}

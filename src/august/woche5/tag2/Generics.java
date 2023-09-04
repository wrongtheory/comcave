package august.woche5.tag2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class MyGenericClass<T>{
	T att;
	T m1(T param) {
		
		return param;
	}
}

class MyGeneric2<T extends Runnable> {}

class PersonV1 {
	public int compareTo(PersonV1 p2) {return 0;}
	public int compareTo(Object p2) {return 0;}
	
}

class PersonV2 implements Comparable<PersonV2> {
	public int compareTo(PersonV2 p2) {return 0;}
	//public int compareTo(Object p2) {return 0;} // cf
	
}

public class Generics {

	public static void main(String[] args) {
		
		((Comparable)new PersonV2()).compareTo("String");
		
		List<String> myListA;
		
		MyGenericClass<Integer> m = new MyGenericClass<>();
		int i = m.m1(25);
		System.out.println(i);
		
		MyGeneric2<Runnable> m2 = new MyGeneric2<>();
		
		List<Integer> listInt = new ArrayList<>();
		
		listInt.add(12);
		listInt.add(Integer.valueOf("12"));
		
		//List<String> listStr = listInt;
		
		//List<Object> listObj = listInt;
		
		
//		Arrays.sort(args);
//		List<Object> l = new ArrayList<>();
//		Collections.sort(l); cf
		
//		Object[] arr = {12,"12"};
//		Arrays.sort(arr); cf
		
		Integer v1 = 12;
		Number v2 = v1;
		
		//v1 = v2; // cf
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		// List<Integer> li = deque; //cf
		
		Collection<String> collStr;
		//collStr = deque; // cf
		
		List<Integer> l = new ArrayList<Integer>();
		
		m(l);
		//m2(l); //cf
		System.out.println(l);
		//Collections.sort(l);
		
		List<Double> ld = m(l);
		
		System.out.println(ld);
		
		ld = m2(new ArrayList<Double>());
		
		Object[] ar = {
				12, "13"
		};
		
		Comparable cmp =  (Comparable)ar[1];
		
		//cmp.compareTo(ar[0]);
		
		//Arrays.sort(ar);
		
		//System.out.println(ar[0]);
		
		
		

	}
	
	static List m(List list) {
		list.add(12);
		list.add("12");
		
		return list;
	}
	
	static List<Double> m2(List<Double> list) {
		//list.add(12);
		//list.add("12");
		
		return list;
	}
	

	
	


}

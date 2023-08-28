package august.woche4.tag2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkAddFirst {

	static ArrayList<String> list = new ArrayList<>(); 
	static LinkedList<String> list2 = new LinkedList<>();
	
	public static void testAddFirst(String str) {
		list.add(0, str);
	}
	
	public static void testAddFirst2(String str) {
		list2.addFirst(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		for(int i=0 ;i<10000;i++) {
			testAddFirst("hallo");
		}
		end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) +" miliseconds");
		System.out.println("Mittelwert: " + (end-start)/10000);
		
		
		long start2 = System.currentTimeMillis();
		long end2 = System.currentTimeMillis();
		for(int i=0 ;i<100000;i++) {
			testAddFirst2("hallo");
		}
		end2 = System.currentTimeMillis();
		System.out.println("Time: " + (end2 - start2) +" miliseconds");
		System.out.println("Mittelwert: " + (end2-start2)/10000);
		

	}

}

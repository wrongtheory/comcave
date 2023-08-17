package august.woche1.tag4.Aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe {
	
	public static ArrayList<String> transform(final String[] arr){
		ArrayList<String> list = (ArrayList<String>) Arrays.asList(arr).stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		return list;
	} 
	
	public  static ArrayList<String> transform(final String[] arr, final int nrAufgabe){

		ArrayList<String> list1 = (ArrayList<String>) Arrays.asList(arr).stream()
				.map(s ->s +".")
				.collect(Collectors.toList());
			
		ArrayList<String> list2 = (ArrayList<String>) Arrays.asList(arr).stream()
				.map(s -> s + "(" + s.length() + ")")
				.collect(Collectors.toList());
		
		if(nrAufgabe == 1)
			return list1;
		return list2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String[]arr = {"mo","di","mi"};
	
	
	
	System.out.println("Original array: " + Arrays.toString(arr));
	
	System.out.println("\n--------------A1-------------");
	ArrayList<String> list = transform(arr); 
	System.out.println(list);
	
	
	
	System.out.println("\n--------------A3-------------");
	list = transform(arr, 1);
	System.out.println(list);
	
	System.out.println("\n--------------A4-------------");
	list = transform(arr, 2);
	System.out.println(list);
	
	}

}

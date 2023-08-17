package august.woche1.tag4.Aufgaben;

import java.util.ArrayList;
import java.util.List;

interface Stringtransformation {
	public String execute(String s);
}

//class StringTransf implements Stringtransformation {
//
//	@Override
//	public String execute(String s) {
//		// TODO Auto-generated method stub
//		return s;
//	}
//}

public class Aufgabe2 {
	
	static ArrayList<String> transform(String[] arr) {
		
		ArrayList<String> list = new ArrayList<>();
		
		for(String s: arr)
			list.add(s.toUpperCase());
		
		return list;
	}
	
	static ArrayList<String> transform(String[] arr, Stringtransformation logic){
		ArrayList<String> list = new ArrayList<>();
		
		for(String s : arr) {
			s = logic.execute(s);
			list.add(s);
		}
		
		return list;
	}

	public static void main(String[] args) {
		
		String[] arr = {"mo","di","mi"};
		
		ArrayList<String> list = transform(arr);
		System.out.println(list);
		
		list = transform(arr, s -> s + ".");
		
		System.out.println(list);
		
		list = transform(arr, s -> s + "("+s.length()+")");
		
		System.out.println(list);

	} // end of main

	
}

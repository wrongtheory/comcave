package august.woche4.tag2;

import java.util.ArrayList;
import java.util.List;

public class ListAPI {

	public static void main(String[] args) {
		
		List<String> listStr = new ArrayList<>();
		
		listStr.add("di");
		listStr.add(0, "mo");
		
		listStr.add(2, "mi");
		
		listStr.forEach(System.out::println);
		System.out.println(listStr);
		
		//listStr.add(77,"we");
		
		//Integer x = listStr.get();
		
		String s = listStr.get(1);
		
		String removedString = listStr.remove(1);
		System.out.println( removedString +  " removed");
		System.out.println(listStr);
		
		
		s = listStr.set(1, "DI");
		System.out.println(listStr);
		int x = listStr.indexOf(null);
		
		System.out.println(x);

	}

}

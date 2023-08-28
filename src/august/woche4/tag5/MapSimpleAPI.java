package august.woche4.tag5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSimpleAPI {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		System.out.println("1. size: " + map.size()); // 0
		
		String s="";
		s+= map.put(1, "Montag");
		System.out.println(s);
		
		System.out.println("2. size: " + map.size()); // 1
		
		
		map.put(2, "di");
		map.put(3, "mi");
		
		System.out.println("2. size: " + map.size()); // 1

		System.out.println("map: " + map);
		
		
		String value = map.get(1);
		
		System.out.println(value);
		
		String oldValue = map.put(5, "fr");
		
		System.out.println("oldValue: " + oldValue);
		
		oldValue = map.put(1, "mo");
		System.out.println(oldValue);
		
		String removeValue = map.remove(1);
		System.out.println("removedValue: " + removeValue);
		

	}

}

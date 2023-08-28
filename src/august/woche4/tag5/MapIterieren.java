package august.woche4.tag5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapIterieren {

	public static void main(String[] args) {
		
		
		Map<Integer, String> map1 = new HashMap<>();
		
		// for(Object entry : map1) {} // cf Map is not Iterable
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		
		Set<Integer> allkeys =  map.keySet();
		
		for(Integer key : allkeys) {
			String value = map.get(key);
			System.out.println(key + " " + value);
		}
		
		
		Collection<String> allValues = map.values();
		
		for(String value : allValues) {
			System.out.println(value);
		}
		
		
		//Map.Entry<Integer, String> entry;
		
		Set<Map.Entry<Integer, String>> allentries = map.entrySet();
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}

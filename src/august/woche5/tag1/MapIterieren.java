package august.woche5.tag1;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapIterieren {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new TreeMap<>();
		
		map.put(1, "jan");
		map.put(3, "mar");
		map.put(4, "apr");
		map.put(2, "feb");
		
//		for(Object x : map) {} // cf; Map ist nicht Iterable

		Set<Integer> allKeys = map.keySet();
		
		for(Integer key : allKeys) {
			String value = map.get(key);
			System.out.println("key: " + key + ", value: " + value);
		}
		
		
		//Map.Entry<Integer, String> entry;
		
		Set<Map.Entry<Integer, String>> allEntries = map.entrySet();
		
		for(Map.Entry<Integer, String> entry : allEntries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		
	} // end main

}

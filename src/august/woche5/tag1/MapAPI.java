package august.woche5.tag1;

import java.util.HashMap;
import java.util.Map;

public class MapAPI {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		map.put(4, null);

		
		System.out.println(map.containsKey(3));
		System.out.println(map.containsKey(4));
		System.out.println(map.containsKey(77));
		
		System.out.println(map.containsValue("di"));
		System.out.println(map.containsValue("fr"));
		
		String value = map.getOrDefault(3, "kein Eintrag");
		System.out.println(value);
		
		
		map.replace(2, "Sonntag");
		
		System.out.println(map);

	}

}

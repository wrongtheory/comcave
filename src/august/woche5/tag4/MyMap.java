package august.woche5.tag4;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

	public static Map<Integer, String> woche() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		map.put(4, "do");
		map.put(5, "fr");
		
		return map;
	}

}

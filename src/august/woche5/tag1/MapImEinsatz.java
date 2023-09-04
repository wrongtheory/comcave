package august.woche5.tag1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapImEinsatz {

	public static void main(String[] args) {
		
		String[] array = {
				"an","von","bis","und","von","an","bevor","danach","an"
		};
		
		/*
		 * 0. Ob und wie oft ein String vorkommt ?
		 * 1. Welche einzigartige Strings gib es ?
		 * 2. Wie oft jeder String vorkommt?
		 */
		
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String s : array) {
			
			Integer count = map.get(s);
			System.out.println(count);
			
			if(count==null) {
				map.put(s, 1);
			} else {
				map.put(s, count + 1);
			}
		}
		
		System.out.println("map: " + map);
		
		Integer count = map.get("unter");
		
		if(count==null)
			System.out.println("kein Eintrag fur key = 'unter' gefunden");
		else
			System.out.println("'unter' = " + count);
		
		System.out.println("'von' = " + map.get("von"));
		
		
		Set<String> allKeys = map.keySet();
		
		for(String key : allKeys) {
			Integer value = map.get(key);
			System.out.println(key + " " + value);
		}

	}//end main
	
	

} // end public class

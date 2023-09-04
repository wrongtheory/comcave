package september.woche1.tag1;

import java.util.HashMap;
import java.util.Map;

public class MapAufgabe {

	public static void main(String[] args) {
		
		System.out.println("**** A1");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Mo");
		map.put(2, "Di");
		map.put(3, "Mi");

		map.forEach((key,value) -> System.out.println(key + " " + value));
		
		System.out.println("**** A2");
		
		Integer key = 2;
		
		map.compute(key, (key2, value) -> "Dienstag");
		
		map.forEach((key2,value) -> System.out.println(key2 + " " + value));
		
		System.out.println("**** A3");
		
		map = new HashMap<>(map);
		
		map.computeIfAbsent(2, k -> "Dienstag");
		
		map.forEach((key2,value) -> System.out.println(key2 + " " + value));
		
		System.out.println("**** A4");
		
		map.computeIfPresent(2, (k,v) -> "Dienstag");
		
		map.forEach((key2,value) -> System.out.println(key2 + " " + value));
		
		System.out.println("**** A5");
		
		 map.merge(2, "Dienstag2", (existingValue, additionalValue) -> { 
		        System.out.println("existing: " + existingValue);
		        System.out.println("additional: " + additionalValue);
		        return existingValue + " (" + additionalValue + ")";
		    } );

		    map.merge(4, "Do", (existingValue, additionalValue) -> { 
		        System.out.println("existing: " + existingValue);
		        System.out.println("additional: " + additionalValue);
		        return existingValue + " (" + additionalValue + ")";
		    } );

		    map.forEach( (i,v) -> System.out.println( i + " = " + v ) );

	}

}

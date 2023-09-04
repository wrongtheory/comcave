package august.woche5.tag1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KleineAufgabeMap {

	public static void main(String[] args) {
		
		
		/*
		 * 1. Erzeugen Sie bitte eine Map<String,LocalDtw>
		 */
		
		Map<String, LocalDate> map = new HashMap<>();
		
		LocalDate date = LocalDate.now();
		map.put("heute", date);
		
		map.put("gestern", date.minusDays(1));
		map.put("morgen", date.plusDays(1));
		
		System.out.println(map);
		
//		Set<String> allKeys = map.keySet();
//		
//		for(String key : allKeys) {
//			date = map.get(key);
//			System.out.println("key: " + key + ", value: " + date);
//		}
		
		
		System.out.println(map);
		
		//Set<Map.Entry<String, LocalDate>> allEntries = map.entrySet();
		
		for(Map.Entry<String, LocalDate> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		
		

	}

}

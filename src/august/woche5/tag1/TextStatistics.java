package august.woche5.tag1;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class TextStatistics {

	private static Collection<Character> coll = new LinkedHashSet<>();
	private static Map<Character, Integer> map = new HashMap<>();

	private static TextStatistics of(String string) {
		
		System.out.println("Original string: " + string);

		//Integer count = 0;
		for (int i = 0; i < string.length(); i++) {
			Character key = string.charAt(i);
			Integer val = map.getOrDefault(key, 0);
			map.put(key, ++val);
//			if (!map.containsKey(key)) {
//				count = 0;
//				map.put(key, count++);
//				
//			} else
//				map.put(key, ++count);
		}

		for (int i = 0; i < string.length(); i++) {
			coll.add(string.charAt(i));
		}

		return new TextStatistics();
	}

	private static Collection<Character> getUniqueChars() {
		return getCharCounts().keySet();
	}

	private static Map<Character, Integer> getCharCounts() {

		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TextStatistics stat = TextStatistics.of("faaaabbccddd");

		Collection<Character> chars = stat.getUniqueChars();

		System.out.print("Einamlige zahlen: ");
		for (Character c : chars)
			System.out.print(c + " ");

		System.out.println();
		
		for(Map.Entry<Character, Integer> m: map.entrySet())
			System.out.println(m.getKey() + " - " + m.getValue());
		 
		System.out.println("\nMap (Zeichen Count) : " + map);
	}

}

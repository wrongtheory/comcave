package september.woche1.tag1;

import java.util.Map;
import java.util.function.BiFunction;
import august.woche5.tag4.MyMap;

public class MapMergeMethod {

	public static void main(String[] args) {
		
		
		Map<Integer, String> map = MyMap.woche();
		
		System.out.println("vorher: " + map);
		

		Integer key = 7;
		String value = "so";
		
		BiFunction<String, String, String> func = (oldValue, value1) -> {
			System.out.println(oldValue);
			System.out.println(value1);
			String newValue = value1 + "(" + oldValue + ")";
			return newValue;
		};
		
		map.merge(key, value, func);
		
		
		System.out.println("nachher: " + map);
		
		
		
		key = 1;
		value = "Montag";
		
		map.merge(key, value, func);
		
		
		System.out.println("nachher: " + map);

	}

}

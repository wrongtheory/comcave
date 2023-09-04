package september.woche1.tag1;

import java.util.Map;
import java.util.function.BiFunction;

import august.woche5.tag4.MyMap;

public class MapComputeExample {

	public static void main(String[] args) {
		
		Map<Integer, String> map = MyMap.woche();
		
		System.out.println("1 map: " + map);
		
		Integer key = 7;
		
		BiFunction<Integer, String, String> func = (keyV, altValue) -> {
			if(altValue == null) {
				return "new value for key " + keyV;
			}
			String newValue = altValue.toUpperCase();
			return newValue;
		};
		
		map.compute(key, func);
		
		System.out.println(map);
		
		key = 1;
		map.compute(key, func);
		
		System.out.println(map);

	}

}

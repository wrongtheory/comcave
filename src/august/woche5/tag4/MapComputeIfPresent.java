package august.woche5.tag4;

import java.util.Map;
import java.util.function.BiFunction;

public class MapComputeIfPresent {

	public static void main(String[] args) {
		
		
		// default V computeIfPresent(K key,
        // BiFunction<? super K, ? super V, ? extends V> remappingFunction)
		
		Map<Integer, String> map = MyMap.woche();
		
		System.out.println(map);
		
		
		Integer key = 2;
		
		BiFunction<Integer, String, String> bifunc = (a,b) -> b.toUpperCase();
		
		map.computeIfPresent(key, bifunc);
		
		
		System.out.println(map);

	}

}

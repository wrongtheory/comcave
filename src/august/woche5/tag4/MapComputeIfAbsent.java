package august.woche5.tag4;

import java.util.Map;
import java.util.function.Function;

public class MapComputeIfAbsent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map = MyMap.woche();
		
		System.out.println(map);
		
		Integer key = 7;
		
		Function<Integer, String> f = (Integer k) -> {
			switch(k) {
				case 6: return "sa";
				case 7: return "so";
			}
			return "seltsam";
		};
		
		map.computeIfAbsent(key, f);
		
		System.out.println(map);
		
		key = 1;
		
		f = x -> "hallo";
		map.computeIfAbsent(key, f);
		System.out.println(map);

	}

}

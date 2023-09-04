package august.woche5.tag4;

import java.util.Map;
import java.util.function.BiFunction;

public class MapReplaceAll {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map = MyMap.woche();
		
		System.out.println(map);
		
		BiFunction<Integer, String, String> bf1 = (Integer key, String oldValue) -> {
			String newValue = oldValue + "(" + key + ")";
			return newValue;
		};
		
		
		BiFunction<Integer, String, String> bf2 = (a,b) -> b.concat("(") + a + ")";
		
		
		
		map.replaceAll(bf1);

		System.out.println(map);
		
		map.replaceAll(bf2);
		
		System.out.println(map);
		
	}

}

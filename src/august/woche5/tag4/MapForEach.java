package august.woche5.tag4;

import java.util.Map;
import java.util.function.BiConsumer;

public class MapForEach {
	
	public static void print(Integer a, String b) {
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map = MyMap.woche();
		
	
		
		BiConsumer<Integer, String> bc2 = (i,s) -> print(i, s);
		BiConsumer<Integer, String> bc3 = MapForEach::print;
		
		BiConsumer<Integer, String> bc = new BiConsumer<Integer, String>() {
			
			@Override
			public void accept(Integer key, String value) {
				
				System.out.println(key + " " + value);
			}
		};
		
		map.forEach(bc);
		map.forEach(bc2);
		map.forEach(bc3);
		
	}

}

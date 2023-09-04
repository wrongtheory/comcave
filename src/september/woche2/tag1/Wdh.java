package september.woche2.tag1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Wdh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Consumer<Integer> c1 = null;
		BiConsumer<Integer, String> c2 = null;
		Consumer<String> c3 = null;
		BiConsumer<Integer, Integer> c4 = null;
		
		Map<Integer, String> map = new HashMap<>();
		
//		map.forEach(c1);
		map.forEach(c2);
//		map.forEach(c3);
//		map.forEach(c4);
		
		Collection<Integer> coll = new ArrayDeque<>();
		
		coll.forEach(c1);
		
		
		

	}

}

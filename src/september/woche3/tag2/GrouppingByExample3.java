package september.woche3.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GrouppingByExample3 {

	public static void main(String[] args) {

		
		String[] array = {
				"aa",
				"bbb",
				"cc",
				"f",
				"eee",
				"d"
			};
			
			/*
			 * Version 3
			 *         public static <T, K, D, A, M extends Map<K, D>>
    					Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
                        Supplier<M> mapFactory,
                        Collector<? super T, A, D> downstream)

			 */
		
		
			Function<String, Integer> clasifier = s -> s.length();
			
			Collector<String, ?, List<String>> downstream = Collectors.toList();
			
			Supplier<Map<Integer, List<String>>> mapFactory = TreeMap::new;

			Collector<String, ?, Map<Integer, List<String>>> c1 = Collectors.groupingBy(clasifier, mapFactory, downstream);
		
			Map<Integer, List<String>> map =  Arrays.stream(array)
				.collect(c1);
			
			map.forEach((a,b) -> System.out.println(a + " " + b));
			
		
		Map<Integer, List<String>> map2 = Arrays.stream(array)
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		
		map2.forEach((a,b) -> System.out.println(a + " " + b));
		
		
	}// end main

}

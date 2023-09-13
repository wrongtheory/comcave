package september.woche3.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByExample {

	public static void main(String[] args) {

		
		Integer[] array = {1, -2, 0,  33, -12, 0, 11, -7, -57};
		
		/*
		 * gruppen:
		 * 
		 * Negative: 
		 * Positive: 
		 * Nullen:
		 * 
		 *     public static <T, K> Collector<T, ?, Map<K, List<T>>>
    			groupingBy(Function<? super T, ? extends K> classifier) {
        		return groupingBy(classifier, toList());
    }

		 */
		
		Function<Integer, String> clasifier = value -> {
			if(value < 0) {
				return "negative";
			}else if(value > 0) {
				return "positive";
			}else {
				return "nullen";
			}
		};
		
		Collector<Integer, ?, Map<String, List<Integer>>> c1 
				=  Collectors.groupingBy(clasifier);
		
		Map<String, List<Integer>> gruppen =  Arrays.stream(array)
			.collect(c1);
		
		gruppen.forEach((a,b) -> System.out.println(a + b));
//		System.out.println("negative" + gruppen.get("negative"));
//		System.out.println("positive" + gruppen.get("positive"));
//		System.out.println("nullen" + gruppen.get("nullen"));
	}

}

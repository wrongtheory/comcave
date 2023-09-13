package september.woche3.tag2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrouppingByExample2 {

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
		 * Version 1
		 *     public static <T, K> Collector<T, ?, Map<K, List<T>>>
    			groupingBy(Function<? super T, ? extends K> classifier) {
        		return groupingBy(classifier, toList());
    }

		 */
		
		Function<String, Integer> clasifier = s -> s.length();
		
//		Collector<String, ?, Map<Integer, List<String>>> c1
//				= Collectors.groupingBy(clasifier);
		
		
		/*
		 * 
		 * Version 2
		 *     public static <T, K, A, D>
    			Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector<? super T, A, D> downstream) 
        		return groupingBy(classifier, HashMap::new, downstream);
    	*
    	*
    	*classifier: wie ein Element der Pipeline einer Gruppe zugeordnet wird
    	*
    	*downstream: wie ein Gruppencontainer erzeugt(supplier), gefullt(accumulator) und kombiniert(combiner) wird

		 */
		
		Collector<String, ?, List<String>> downstream = Collectors.toList();
		
		Collector<String, ?, Map<Integer, List<String>>> c1 = Collectors.groupingBy(clasifier, downstream);
		
		Map<Integer, List<String>> map1 = Stream.of(array)
			.collect(c1);
		
		map1.forEach((a,b) -> System.out.println(a + " " + b));
		
		
		
		/*
		 * Version 2 mit TreeSet
		 */
		
		Collector<String, ?, TreeSet<String>> downstream2 = Collectors.toCollection(TreeSet::new);
		
		Collector<String, ? , Map<Integer, TreeSet<String>>> c2 = Collectors.groupingBy(clasifier, downstream2);
		
		Map<Integer, TreeSet<String>> map2 =  Stream.of(array)
			.collect(c2);
		
		map2.forEach((a,b) -> System.out.println(a + " " + b));
		
	} // end main

}

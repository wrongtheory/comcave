package september.woche3.tag1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CollectorMappingExample {

	public static void main(String[] args) {

		
		String[] array = {"a", "bbb", "cc", "dddd"};
		
		/*
		 * mit der intermadeiate map
		 */
		
		Function<String, Integer> mapper1 = String::length;
		
		Collector<Integer, ?, List<Integer>> c1 = Collectors.toList();
		
		List<Integer> list1 =  Arrays.stream(array) // Stream<String>
			.map(mapper1)	//Stream<Integer>
			.collect(c1);
		
		System.out.println("list1: " + list1);
		
		/*
		 * mit der mapping-Collector
		 * 
		 *  public static <T, U, A, R>
    		Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
                               Collector<? super U, A, R> downstream) {
        	BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        	return new CollectorImpl<>(downstream.supplier(),
                                   (r, t) -> downstreamAccumulator.accept(r, mapper.apply(t)),
                                   downstream.combiner(), downstream.finisher(),
                                   downstream.characteristics());
		 */
		
//		Function<String, Integer> mapper2 = mapper1;
		Function<String, Integer> mapper2 = String::length;
		
		Collector<Integer, ?, List<Integer>> downstream = Collectors.toList();
		
		Collector<String, ?, List<Integer>> c2 = Collectors.mapping(mapper2, downstream);
		
		List<Integer> list2 = Arrays.stream(array)
									.collect(c2);
		
		System.out.println("list2: " + list2);
		
		List<Integer> list3 = 
				Arrays.stream(array).collect(Collectors.mapping(String::length, Collectors.toList()));
		
		System.out.println("list3: " + list3);
		
		
		
	}

}

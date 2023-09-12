package september.woche3.tag1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class CollectorsExample {

	public static void main(String[] args) {
		
		String[] array = {"a","bb","ccc","d", "bb"};
		
		/*
		 * public static <T>
    		Collector<T, ?, List<T>> toList() {
        	return new CollectorImpl<>(ArrayList::new, List::add,
                                   (left, right) -> { left.addAll(right); return left; },
                                   CH_ID);
		 */
		
		Collector<String, ?, List<String>> c1 = Collectors.toList();
		
		List<String> list1 =  Stream.of(array)
			.collect(c1);
		
		System.out.println("list1: " + list1);
		
		/*
		 * Collector<T, ?, Set<T>> toSet() {
        	return new CollectorImpl<>(HashSet::new, Set::add,
                                   (left, right) -> {
                                       if (left.size() < right.size()) {
                                           right.addAll(left); return right;
                                       } else {
                                           left.addAll(right); return left;
                                       }
                                   },
                                   CH_UNORDERED_ID);
		 */
		
		Collector<String, ?, Set<String>> c2 = Collectors.toSet();
		
		Set<String> set2 = Stream.of(array).collect(c2);
		
		System.out.println("set2: " + set2);
		
		
		/*
		 * public static <T, C extends Collection<T>>
    		Collector<T, ?, C> toCollection(Supplier<C> collectionFactory) {
        	return new CollectorImpl<>(collectionFactory, Collection<T>::add,
                                   (r1, r2) -> { r1.addAll(r2); return r1; },
                                   CH_ID);
		 */
		
		
		Collector<String, ?, ArrayList<String>> c3 
				=  Collectors.toCollection(ArrayList::new);
		
		ArrayList<String> list3 =  Stream.of(array).collect(c3);
		
		System.out.println("list3: " + list3);
		
		Collector<String, ?, Deque<String>> c4
				= Collectors.toCollection(ArrayDeque::new);
		
		Deque<String> deq = Stream.of(array).collect(c4);
		
		System.out.println("deque: " + deq);
		
		/*
		 *  public static <T, K, U>
    		Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper) {
        	return new CollectorImpl<>(HashMap::new,
                                   uniqKeysMapAccumulator(keyMapper, valueMapper),
                                   uniqKeysMapMerger(),
                                   CH_ID);
		 */
		
		Integer[] zahlen = {1, 2, 3, 8, 7};
		
		Function<Integer, Integer> keyMapper = x -> x;
		
		Function<Integer, String> valueMapper = x -> {
			if(x%2==0)
				return "gerade";
			return "ungerade";
		};
		
		
		
		Collector<Integer, ?, Map<Integer, String>> cmap =  Collectors.toMap(keyMapper, valueMapper);
		
		Map<Integer, String> map =  Arrays.stream(zahlen)
			.collect(cmap);
		
		System.out.println("map: " + map);
		
		
		

	}

}

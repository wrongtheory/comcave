package september.woche3.tag1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectExample {

	public static void main(String[] args) {
		
		Integer[] array = {1,2,1,3,1,4,1,5};
		
		/*
		 * Version1
		 *  <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
		 */
		
		
		Supplier<Set<Integer>> supp = HashSet::new;
		
		BiConsumer<Set<Integer>, Integer> acc = Set::add;
		
		BiConsumer<Set<Integer>, Set<Integer>> comb = Set::addAll;
		
		Set<Integer> set1 =  Arrays.stream(array)
			.collect(supp, acc, comb);
		
		System.out.println("set1: " + set1);
		
		
		/*
		 * Version2
		 *  <R, A> R collect(Collector<? super T, A, R> collector);
		 */
		
		Collector<Integer, ?, Set<Integer>> c1;
		
		Set<Integer> set2 = Arrays.stream(array).collect(Collectors.toSet());
		
		System.out.println("set2: " + set2);

	}

}

package september.woche3.tag1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabeCollect {

	static String[] arr = { "1,2,3,4,5", "7,6,5,4,3", "123,456" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		a1_0();
		a1_1();
		a1_2();
		a1_3();
		a1_4();
		a1_5();
		a1_6();
		a2();
	}

	static void a1_0() {

		System.out.println("**********A1 ohne streams**************\n");

		List<Integer> list;

		// A
		list = new ArrayList<>();
		for (String s : arr) {
			String[] stringNumbers = s.split(",");

			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				list.add(num);
			}
		}
		// B

		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
	}

	static void a1_1() {
		System.out.println("\n**********A1 mit streams**************\n");

		/*
		 * <R, A> R collect(Collector<? super T, A, R> collector); public interface
		 * Collector<T, A, R>
		 * 
		 */

		/*
		 * Version1 <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>
		 * accumulator, BiConsumer<R, R> combiner);
		 */

		Supplier<List<Integer>> supp = ArrayList::new;
		BiConsumer<List<Integer>, Integer> acc = List::add;
		BiConsumer<List<Integer>, List<Integer>> combiner = List::addAll;

		List<Integer> listResult = Arrays.stream(arr)
				.flatMap(x -> Stream.of(x.split(",")))
				.map(x -> Integer.valueOf(x))
				.collect(supp, acc, combiner);

		System.out.println(listResult);
	}

	static void a1_2() {
		/*
		 * Version2 <R, A> R collect(Collector<? super T, A, R> collector);
		 */
		List<Integer> list2 = Arrays.stream(arr)
				.flatMap(x -> Stream.of(x.split(",")))
				.map(x -> Integer.valueOf(x))
				.collect(Collectors.toList());

		System.out.println(list2);
	}

	static void a1_3() {
		/*
		 * Version3 public static <T, C extends Collection<T>> Collector<T, ?, C>
		 * toCollection(Supplier<C> collectionFactory) { return new
		 * CollectorImpl<>(collectionFactory, Collection<T>::add, (r1, r2) -> {
		 * r1.addAll(r2); return r1; }, CH_ID);
		 */

		List<Integer> list3 = Arrays.stream(arr)
				.flatMap(x -> Stream.of(x.split(",")))
				.map(x -> Integer.valueOf(x))
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println(list3);
	}

	static void a1_4() {

		/*
		 * Version4
		 */

		Collector<Integer, ?, List<Integer>> coll = Collectors.toCollection(ArrayList::new);
		Function<String, Integer> func = x -> Integer.valueOf(x);
		Function<String, Stream<String>> func2 = x -> Stream.of(x.split(","));

		List<Integer> list4 = Arrays.stream(arr)
				.flatMap(func2).map(func)
				.collect(coll);

		System.out.println(list4);
	}

	static void a1_5() {

		/*
		 * Version5
		 * 
		 * 
		 * mit der mapping-Collector
		 * 
		 * public static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ?
		 * extends U> mapper, Collector<? super U, A, R> downstream) { BiConsumer<A, ?
		 * super U> downstreamAccumulator = downstream.accumulator(); return new
		 * CollectorImpl<>(downstream.supplier(), (r, t) ->
		 * downstreamAccumulator.accept(r, mapper.apply(t)), downstream.combiner(),
		 * downstream.finisher(), downstream.characteristics());
		 */

		Function<String, Integer> funcStringtInt = Integer::valueOf;
		Function<String, Stream<String>> stringToStream = x -> Stream.of(x.split(","));
		Collector<Integer, ?, List<Integer>> coll1 = Collectors.toList();

		Collector<String, ?, List<Integer>> coll2 = Collectors.mapping(funcStringtInt, coll1);

		List<Integer> list5 = Arrays.stream(arr)
				.flatMap(stringToStream)
				.collect(coll2);

		System.out.println(list5);

	}

	static void a1_6() {

		/*
		 * Version6
		 * 
		 * 
		 * mit der mapping-Collector
		 * 
		 * public static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ?
		 * extends U> mapper, Collector<? super U, A, R> downstream) { BiConsumer<A, ?
		 * super U> downstreamAccumulator = downstream.accumulator(); return new
		 * CollectorImpl<>(downstream.supplier(), (r, t) ->
		 * downstreamAccumulator.accept(r, mapper.apply(t)), downstream.combiner(),
		 * downstream.finisher(), downstream.characteristics());
		 */

		List<Integer> list6 = Arrays.stream(arr)
				.flatMap(x -> Stream.of(x.split(",")))
				.collect(Collectors.mapping(x -> Integer.valueOf(x), Collectors.toList()));

		System.out.println(list6);
		
		List<Object> ll =  Arrays.stream(arr)
			.collect(Collectors.mapping(x->x.split(","), Collectors.toList()))
			.stream()
			.collect(Collectors.flatMapping(x->Stream.of(x) , Collectors.toList()));
					

		System.out.println("ll: " + ll);
				
	}

	static void a2() {
		System.out.println("\n****************A2********************\n");

		List<Integer> list7 = Arrays.stream(arr)
				.flatMap(x -> Stream.of(x.split(",")))
				.map(x -> Integer.valueOf(x))
				.filter(x -> x % 2 == 0)
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println(list7);

	}

}

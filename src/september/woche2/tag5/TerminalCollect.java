package september.woche2.tag5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TerminalCollect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array = { 1, 2, 3, 4, 5 };

		/*
		 * <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,
		 * BiConsumer<R, R> combiner);
		 * 
		 * public interface Supplier<T> T get();
		 * 
		 * public interface BiConsumer<T, U> void accept(T t, U u);
		 * 
		 */

		Supplier<List<Integer>> supplier = ArrayList::new;
//		Supplier<List<Integer>> supplier = () -> new ArrayList();

		BiConsumer<List<Integer>, Integer> acc = (list, nextElement) -> list.add(nextElement);
//		BiConsumer<List<Integer>, Integer> acc = ArrayList::add; // cf

		BiConsumer<List<Integer>, List<Integer>> comb = (listA, listB) -> listA.addAll(listB);
//		BiConsumer<List<Integer>, List<Integer>> comb = ArrayList::addAll; // cf

		List<Integer> list = Arrays.stream(array).parallel().collect(supplier, acc, comb);

		System.out.println("list: " + list);

		kleineAufgabe();
		kleineAufgabe2();

	}

	static void kleineAufgabe() {
		System.out.println("****kleine Aufgabe");

		String[] array = { "a", "bb", "ccc", "dddd", "eeeee" };

		Supplier<List<Integer>> sup = LinkedList::new;

		BiConsumer<List<Integer>, String> acc = (list, nextStr) -> list.add(nextStr.length());

		BiConsumer<List<Integer>, List<Integer>> comb = (a, b) -> a.addAll(b);

		List<Integer> list = Stream.of(array).collect(sup, acc, comb);

		System.out.println("List: " + list);
	}

	static void kleineAufgabe2() {

		String[] array = { "a", "b", "c", "d", "e" };

		StringBuilder sb = Stream.of(array)
				.parallel()
				.collect(StringBuilder::new, StringBuilder::append,StringBuilder::append);

		System.out.println("StringBuilder: " + sb);

	}

}

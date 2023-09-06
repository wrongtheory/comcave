package september.woche2.tag2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		
		
		String[] a1 = {"a","b"};
		String[] a2 = {"c","d"};
		String[] a3 = {"e","f"};
		String[] a4 = {"g","h"};

		
		/*
		 * flatMap
		 *  <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
		 *  public interface Function<T, R>
		 *  R apply(T t);
		 * 
		 */
//		
//		Stream.of(a1,a2,a3,a4)
//		.flatMap(x -> Arrays.stream(x))
//			.forEach(s -> System.out.println(s));
		
		
		Stream.of(a1,a2,a3,a4)
		.flatMap(Stream::of)
			.forEach(s -> System.out.println(s));
		
		System.out.println("aufgabe");
		kleineAufgabe();
		
	}
	
	static void kleineAufgabe() {
		
		//System.out.println(makeList("abc"));
		
		
		List<List<Character>> data = Arrays.asList(makeList("abc"), makeList("def"), makeList("ghi"));
		
		data.stream() // list<list<char>>
			//.flatMap(a -> Stream.of(a))
			.flatMap(b -> b.stream())
			.forEach(s->System.out.println(s));
		
//		data.stream() // list<list<char>>
//			.flatMap(x -> x.stream())
//			.flatMap(Stream::of)
//			.forEach(s->System.out.println(s));
//		
//		Stream.of(data)
//			.peek(a->System.out.println(a))
//			.flatMap(b -> b.stream())
//			.peek(a->System.out.println(a))
//			.flatMap(c -> c.stream())
//			.peek(a->System.out.println(a))
//			.forEach(a -> System.out.println(a));
//		
//		data.stream()
//			.flatMap(list -> list.stream())
//			.forEach(s -> System.out.println(s));
		
	//	intermediate operation peek hilft zu sehen was gerade in stream bei jedem Schritt passiert
		
		
//		Stream.of(data)
//			.flatMap(Stream::of)
//			.forEach(s->System.out.println(s));
		
	}
	
	static List<Character> makeList(String s) {
		List<Character> list = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			list.add(s.charAt(i));
		}
		
		return list;
	}

}

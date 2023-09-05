package september.woche1.tag1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamDatenQuelle {

	public static void main(String[] args) {
		
		
		streamFurCollections();
		streamFurArrays();
		streamMitStreamAPI();
		streamMitWeitereMethoden();

	}
	
	static void streamMitWeitereMethoden() {
		String s = "abc";
		
		s.chars()
			.mapToObj(x -> (char)x)
			.forEach(x -> System.out.println(x));
		
		
		try(Stream<Path> stream = Files.list(Paths.get("."))){
			stream.forEach(x -> System.out.println(x));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
}
	
	static void streamMitStreamAPI() {
		
		Stream.empty().forEach(x -> System.out.println(x));
		
		/*
		 * public static<T> Stream<T> generate(Supplier<? extends T> s)
		 * public interface Supplier<T>
		 * T get();
		 */
		
		Supplier<Double> s = () -> 3.5;
		
		Stream.generate(s)
			.limit(10) // Stream<T> limit(long maxSize);
			.forEach(x -> System.out.println(x)); // void forEach(Consumer<? super T> action);
		
		/*
		 * public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 * public interface UnaryOperator<T> extends Function<T, T> 
		 * R apply(T t);
		 */
		
		Integer seed = 1;
		UnaryOperator<Integer> op = x -> ++x;
		
		Stream.iterate(seed, op)
			.limit(4)
			.forEach(x -> System.out.println(x));
		
		
		/*
		 *  public static<T> Stream<T> of(T t)
		 */
		
		String element = "mo";
		Stream.of(element)
			.forEach(x -> System.out.println(x));
		
		
		Stream.of("mo","di","mi")
			.forEach(x -> System.out.println(x));
		
		String[] ss = {"a","b","c"};
		
		Arrays.stream(ss).forEach(x -> System.out.println(x));
		
		
		Stream<Integer> s1 = Stream.iterate(5, x -> x -1).limit(3);
		
		Stream<String> s2 = Stream.of("7","8","9");
		
		Stream.concat(s1, s2)
			.forEach(x -> System.out.println(x));
	}
	

	
	static void streamFurArrays() {
		
		System.out.println("Array");
		
		Integer[] array = {1,11,2,12,3,13,4,14};
		
		Arrays.stream(array)
			.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		Arrays.stream(array, 1, 6)
			.forEach(x-> System.out.println(x));
		
		
	}
	
	static void streamFurCollections() {
		
		Collection<String> coll = new HashSet<>();
		coll.add("mo");
		coll.add("do");
		coll.add("mi");
		coll.add("Tom");
		coll.add("Jerry");
		coll.add("Jerry");
		
		System.out.println("\nHashSet: ");
		coll.stream()
			.forEach(x -> System.out.println(x));
		
		coll = new TreeSet<>(coll);
		
		System.out.println("\nTreeSet: ");
		
		coll.stream()
		.forEach(x -> System.out.println(x));
		
		System.out.println("\nParallel TreeSet: ");
		
		coll.parallelStream()
		.forEach(x -> System.out.println(x));

		
	}

}

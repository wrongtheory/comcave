package september.woche1.tag1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class StreamDatenQuelle {

	public static void main(String[] args) {
		
		
		streamFurCollections();
		streamFurArrays();

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

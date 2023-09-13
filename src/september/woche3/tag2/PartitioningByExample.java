package september.woche3.tag2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByExample {

	public static void main(String[] args) {
		kleineAufgabe();
		kleineAufgabe2();
		
		String[] array = {"ab","bb","ob","cc","ia","gh"};
		
		/*
		 * 
		 * Version 1
		 *     public static <T>
    			Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
        		return partitioningBy(predicate, toList());
    }

		 */
		
		Predicate<String> predicate = s -> hatVokal(s);
		
		Collector<String, ?, Map<Boolean, List<String>>> c1 = 
				Collectors.partitioningBy(predicate);
		
		Map<Boolean, List<String>> map = Arrays.stream(array)
				.collect(c1);
		
		map.forEach((a,b) -> System.out.println(a + " " +  b));
		
		
		
		/*
		 * Version 2
		 * 
		 *     public static <T, D, A>
    			Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
                                                    Collector<? super T, A, D> downstream)
		 */
		
		Collector<String, ?, ArrayDeque<String>> downstream = Collectors.toCollection(ArrayDeque::new);
		
		
		Collector<String, ?, Map<Boolean, ArrayDeque<String>>> c2 = Collectors.partitioningBy(predicate, downstream);
		
		Map<Boolean, ArrayDeque<String>> map2 = Arrays.stream(array)
				.collect(c2);
		
		map2.forEach((a,b) -> System.out.println(a + " " +  b));
	}
	
	static void kleineAufgabe() {
		String[] array = {"ab","bb","ob","cc","ia","gh"};
		
		/*
		 * Gruppen:
		 * "mit": Strings mit mindestens einem Vokal
		 * "ohne": Strings ohne Vokale
		 */
		
		Function<String, String> clasifier = value -> {
			//String s = value;
			String[] chars  = {"a","e","i","o","u"};
			for(int i=0;i<value.length();i++) {
				for(int j=0;j<chars.length;j++) {
					if(value.contains(chars[j])) {
						return "mit";
					}
				}
			}
			return "ohne";
		};
		
		
		Collector<String, ?, Map<String, List<String>>> c1 
				=  Collectors.groupingBy(clasifier);
		
		Map<String, List<String>> gruppen =  Arrays.stream(array)
				.collect(c1);


		
		//Map<String, List<String>> gruppen;
		gruppen.forEach((a,b) -> System.out.println(a + b));
	}
	
	static void kleineAufgabe2() {
		
		String[] array = {"ab","bb","ob","cc","ia","gh"};
		
		Function<String, String> classif = s -> 
		{
			if(hatVokal(s))
				return "mit";
			return "ohne";
		};
		
		
		Map<String, List<String>> gruppen = Stream.of(array)
				.collect(Collectors.groupingBy(classif));
		
		gruppen.forEach((a,b) -> System.out.println(a + b));
		
	}
	
	static final List<Character> vokale = Arrays.asList('a','o','u','e','i');
	
	static boolean hatVokal(String s) {
		return s.chars()
				.mapToObj(i -> (char)i)
				.filter(ch -> vokale.contains(ch))
				.findAny().isPresent();
	}

}

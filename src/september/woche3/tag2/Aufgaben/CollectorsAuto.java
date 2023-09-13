package september.woche3.tag2.Aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class CollectorsAuto {

	public static void main(String[] args) {
		
		List<Auto> autos = Arrays.asList(
                new Auto("VW", "Golf"),
                new Auto("VW", "Polo"),
                new Auto("Opel", "Corsa"),
                new Auto("Opel", "Astra")
            );

		System.out.println("*******************A1 mapping******************************");
		Mapping(autos);
		Mapping2(autos);
		System.out.println("*******************A2 groupingBy***************************");
		groupingBy1(autos);
		groupingBy1_2(autos);
		System.out.println("*******************A3 groupingBy***************************");
		groupingBy2(autos);
		groupingBy2_1(autos);
		System.out.println("*******************A4 groupingBy***************************");
		groupingBy3(autos);
		groupingBy3_1(autos);
		System.out.println("*******************A5 partitioningBy***********************");
		partitioningBy1(autos);
		partitioningBy1_1(autos);
	}
	
	private static void Mapping(List<Auto> autos) {
		
		/*
		 *     Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
         *                      Collector<? super U, A, R> downstream)
		 */
		
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		
		Function<Auto, String> mapper = hersteller -> hersteller.getHersteller();
		
		Collector<Auto, ?, Set<String>> collector = Collectors.mapping(mapper, downstream);
		
		Set<String> set = autos.stream().collect(collector);
		
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
	}
	
	private static void Mapping2(List<Auto> autos) {
		Set<String> set = autos.stream()
				.collect(Collectors.mapping(Auto::getHersteller, Collectors.toSet()));
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
	}
	
	private static void groupingBy1(List<Auto> autos) {
		
		/*
		 *     public static <T, K> Collector<T, ?, Map<K, List<T>>>
    	 *		groupingBy(Function<? super T, ? extends K> classifier) 
		 */
		
		Function<Auto, String> clasifier = Auto::getHersteller;
		
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(clasifier);
		
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		
		System.out.println(map);// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
	}
	
	private static void groupingBy1_2(List<Auto> autos) {
		
		/*
		 *     public static <T, K> Collector<T, ?, Map<K, List<T>>>
    	 *		groupingBy(Function<? super T, ? extends K> classifier) 
		 */
		
		Map<String, List<Auto>> map = autos.stream()
				.collect(Collectors.groupingBy(Auto::getHersteller));
		System.out.println(map);// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
	}

	private static void groupingBy2(List<Auto> autos) {
		
		/*
    	 * Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
         * Collector<? super T, A, D> downstream)		 
		 */
		
		Map<String, List<String>> map = autos.stream()
				.collect(Collectors.groupingBy(Auto::getHersteller, 
							Collectors.mapping(Auto::getModell, Collectors.toList())));
		
		System.out.println(map); // mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
	}
	
	private static void groupingBy2_1(List<Auto> autos) {
		
		/*
    	 * Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
         * Collector<? super T, A, D> downstream)		 
		 */
		
		Function<Auto, String> clasifier = Auto::getHersteller;
		
		Collector<Auto, ?, List<String>> downstream = Collectors.mapping(Auto::getModell, Collectors.toList());		
		
		Collector<Auto, ? , Map<String, List<String>>> collector = Collectors.groupingBy(clasifier, downstream);
		
		Map<String, List<String>> map = autos.stream()
				.collect(collector);
		
		System.out.println(map); // mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
	}
	
	private static void groupingBy3(List<Auto> autos) {
		
		Function<Auto, String> clasifier = Auto::getHersteller;
		
		Collector<Auto, ?, List<Auto>> downstream = Collectors.toList();
		
		Supplier<Map<String, List<Auto>>> mapFactory = TreeMap::new;
		
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(clasifier, mapFactory, downstream);
		
		Map<String, List<Auto>> map = autos.stream()
				.collect(collector);
		
		System.out.println(map); // Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}	
	}

	private static void groupingBy3_1(List<Auto> autos) {
		
		Map<String, List<Auto>> map = autos.stream()
				.collect(Collectors.groupingBy(Auto::getHersteller, TreeMap::new, Collectors.toList()));
		
		System.out.println(map); // Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}	
	}

	private static void partitioningBy1(List<Auto> autos) {
		
		/*
		 *    Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
         *    Collector<? super T, A, D> downstream)
		 */
		
		Map<Boolean, List<Auto>> map = autos.stream()
				.collect(Collectors.partitioningBy(model -> model.getModell().contains("o"), Collectors.toList()));
		
		System.out.println(map); // {false=[Opel/Astra], true=[VW/Golf, VW/Polo, Opel/Corsa]}
	}
	
	private static void partitioningBy1_1(List<Auto> autos) {
	
		Predicate<Auto> predicate = a -> a.getModell().contains("o");
		
		Collector<Auto, ?, List<Auto>> downstream = Collectors.toList();

		Collector<Auto, ?, Map<Boolean, List<Auto>>> collector = Collectors.partitioningBy(predicate, downstream);
		
		Map<Boolean, List<Auto>> map = autos.stream()
				.collect(collector);
		
		System.out.println(map); // {false=[Opel/Astra], true=[VW/Golf, VW/Polo, Opel/Corsa]}
	}
}

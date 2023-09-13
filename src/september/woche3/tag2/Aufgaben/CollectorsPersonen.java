package september.woche3.tag2.Aufgaben;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DuplicateFormatFlagsException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsPersonen {

	public static void main(String[] args) {

		Person[] personen = {
			    new Person("Tom", "Bauarbeiter(in)"),   
			    new Person("Jerry", "Lehrer(in)"),  
			    new Person("Peter", "Metzger(in)"), 
			    new Person("Paul", "Bauarbeiter(in)"),  
			    new Person("Mary", "Lehrer(in)"),   
			};
		
		System.out.println("**********************A1******************************");
		savePersoninTreeSet(personen);
		System.out.println("**********************A2.1****************************");
		toMap(personen);
		System.out.println("**********************A2.2****************************");
		toMap2(personen);
		System.out.println("**********************A3.1****************************");
		a3mapping1(personen);
		System.out.println("**********************A3.2****************************");
		a3mapping2(personen);
		System.out.println("**********************A4******************************");
		groupingnachBeruf(personen);
		System.out.println("**********************A5******************************");
		partitioningByBauarbeiter(personen);

		
	

	}// end main
	
	private static void savePersoninTreeSet(Person[] personen) {
				
		TreeSet<Person> pers = 
				Stream.of(personen)
				.collect(Collectors.toCollection(TreeSet::new));
		
		pers.forEach(a -> System.out.println(a));
		
		//System.out.println(pers);
	}
	
	private static void toMap(Person[] personen) {

		Map<String, String> map = Stream.of(personen)
				.collect(Collectors.toMap(Person::getName, Person::getBeruf));
		
		map.forEach((a,b) -> System.out.println(a + " " + b));
	}
	
	private static void toMap2(Person[] personen) {
		
		Function<Person, String> key = a -> a.getName();
		Function<Person, Person> value = b -> b;

		Map<String, Person> map = Stream.of(personen)
				.collect(Collectors.toMap(key, value));
		
		map.forEach((a,b) -> System.out.println(a + " " + b));
		
		//System.out.print(map);
	}
	
	private static void a3mapping1(Person[] personen) {
		
		Function<Person, String> berufe = person -> person.getBeruf();
		Collector<String, ?, TreeSet<String>> downstream = Collectors.toCollection(() -> new TreeSet());
		
		TreeSet<String> set =  Arrays.stream(personen)
			.collect(Collectors.mapping(berufe, downstream));
		
		set.forEach(a -> System.out.println(a));
		
	}
	
	private static void a3mapping2(Person[] personen) {
		
		TreeSet<String> set =  Arrays.stream(personen)
			.collect(Collectors.mapping(Person::getBeruf, Collectors.toCollection(TreeSet::new)));
		
		set.forEach(a -> System.out.println(a));
	}
	
	private static void groupingnachBeruf(Person[] personen) {
		
		Map<String, List<String>> berufe = 
				Arrays.stream(personen)
				.collect(Collectors.groupingBy(Person::getBeruf, Collectors.mapping(Person::getName, Collectors.toList())));
		
		berufe.forEach((a,b) -> System.out.println(a + " : " +  b));
	}
	
	private static void partitioningByBauarbeiter(Person[] personen) {
		
		Map<Boolean, List<Person>> bau = Arrays.stream(personen)
				.collect(Collectors.partitioningBy(pers -> pers.getBeruf() == "Bauarbeiter(in)", Collectors.toList()));
		
		bau.forEach((a,b) -> System.out.println(a + " - " + b));
		//System.out.println(bau);
		
	}

}

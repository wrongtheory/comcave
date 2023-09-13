package september.woche3.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WdhGroupingBy {

	static class Tier {
		private String name;

		public Tier(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}

	public static void main(String[] args) {

		List<String> namen = Arrays.asList("Tom", "Waldi", "Jerry", "Mietzi", "Rex", "Pluto");

		/*
		 * Tiere grupieren nach der Namenlaenge
		 */

		Function<String, Integer> clasifier = String::length;

		Collector<String, ?, List<Tier>> downstream = Collectors.mapping(Tier::new, Collectors.toList());

		Collector<String, ?, Map<Integer, List<Tier>>> c1 = Collectors.groupingBy(clasifier, downstream);

		Map<Integer, List<Tier>> gruppen = namen.stream().collect(c1);

		for (Integer name : gruppen.keySet()) {
			List<Tier> gruppe = gruppen.get(name);
			System.out.println("- Namenslaenge: " + name);
			System.out.println(" Tiere: " + gruppe);
		}

		gruppen = namen.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.mapping(Tier::new, Collectors.toList())));

		gruppen.forEach((a, b) -> System.out.println("Namelange: " + a + " " + b));

	}

}

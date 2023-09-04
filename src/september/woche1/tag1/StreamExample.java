package september.woche1.tag1;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		
		
		List<Integer> datenquelle = Arrays.asList(8,7,45,33);
		
		datenquelle.stream()
			.map(x -> x + 1)
			.map(x -> x * 2)
			.forEach(System.out::println);

	}

}

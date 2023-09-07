package september.woche2.tag3;

import java.util.stream.Stream;

public class Parallel_Sequential {

	public static void main(String[] args) {
		
		
		
		
		Stream.of(1,2,3,4,5,6)
			.parallel()
			.sequential()
			.parallel()
			.sequential()
			.forEach(s -> System.out.println(s));

	}

}

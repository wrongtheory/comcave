package september.woche2.tag3;

import java.util.stream.Stream;

public class TestSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream.generate(() -> 1)
			.sorted()
			.forEach(s -> System.out.println(s));

	}

}

package september.woche2.tag1;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class IntermediateLimitSkip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long maxSize = 4;
		
	Stream.iterate(1, x -> x + 1)
		.limit(maxSize)
		.forEach(x -> System.out.println(x));
	
	System.out.println("\n****limit-skip\n");
	
	long n = 3;
	
	Stream.iterate(1, x -> x + 1)
		.limit(maxSize)	
		.skip(n)
		.forEach(x -> System.out.println(x));


	}

}

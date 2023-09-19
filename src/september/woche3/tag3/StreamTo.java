package september.woche3.tag3;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTo {

	public static void main(String[] args) {

		testTreamToXxxStream();
		testXxxStreamToStream();
		testYyyStreamToZzzStream();
	}
	
	private static void testYyyStreamToZzzStream() {
		System.out.println("*** XxxStream to ZzzStream");
		
		IntStream.of(1,2,3,4)
			.map(x -> x)
			.forEach(s -> System.out.println(s));
		
		IntStream.of(1,2,3,4)
			.mapToDouble(x -> x)
			.forEach(s -> System.out.println(s));
		
		IntStream.of(1,2,3).asLongStream().map(x -> x).forEach(s -> System.out.println(s));
		
	}
	
	private static void testXxxStreamToStream() {
		System.out.println("*** XxxStream to Stream");
		
		
		class Rakete {
			double tempo;
			Rakete(double tempo) {
				this.tempo = tempo;
			}
			
			public String toString() {
				return "Rakete " + tempo; 
			}
		}
		
		DoubleStream.iterate(1.0, x -> x + 1.1)
			.limit(3)
			.mapToObj(x -> new Rakete(x))
			.forEach(s -> System.out.println(s.getClass()));
		
		IntStream.of(1,2,3,4)
			.boxed() // Stream<Integer>
			.map(x -> x.getClass())
			.forEach(s -> System.out.println(s));
	}

	static void testTreamToXxxStream() {
		System.out.println("*** Stream to XxxStream");
		
		Stream.of(1,2,3,4)
			.mapToDouble(x -> x+1).forEach(s -> System.out.println(s));
	}

}

package september.woche2.tag2;

import java.util.Arrays;
import java.util.stream.Stream;

public class KleineAufgabe {
	
	
	
	static class Numbers{
		
		int seed;
		
		public Numbers(int seed) {
			this.seed = seed;
		}
		
		
		Stream<Integer> getStream(){
			return Stream.iterate(seed, x -> x * 2).limit(3);
		}
		
		public String toString() {
			return "Numbers";
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Numbers[] data = {new Numbers(1), new Numbers(6)};
		
		Arrays.stream(data)
			//.peek(a->System.out.println(a))
			.flatMap(x -> x.getStream())
			//.peek(a->System.out.println(a))
			.forEach(s -> System.out.println(s));
		
		

		
		
	}

}

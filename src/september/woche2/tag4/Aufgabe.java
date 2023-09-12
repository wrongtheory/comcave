package september.woche2.tag4;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Aufgabe {

	public static void main(String[] args) {
		
		System.out.println("************A1**********************************");
		
		
		/*
		 * ###### A1.
			Bilden Sie bitte eine Pipeline, die die Gesamtlänge aller Strings (Gesamtanzahl aller Zeichen) 
			aus folgendem Array berechnet. Verwenden Sie wenn möglich die `reduce` mit zwei Parameter.

			String[] items = { "aa", "bbb", "cccc", "ddddd" };

			> Intermediate Operations sind erlaubt
			
			    <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);

		 */
		
		String[] items = { "aa", "bbb", "cccc", "ddddd" };
		
		
		Integer ident = 0;
		
		BinaryOperator<Integer> acc = (a,b) -> a + b;
		Function<String, Integer> mapper = x -> x.length();
		
		Integer first = Stream.of(items)
			.map(mapper)
			.reduce(ident, acc);
		
		System.out.println("First length: " + first);
		
		
		BinaryOperator<Integer> bo = (a,b) -> a + b;
		BiFunction<Integer, String, String> bf = (a,b) -> b + "" + a;
		
		String ss = Arrays.stream(items)
			.reduce("", (a,b) ->  a.concat(b) + " - "+ b.length()+"\n");
		System.out.println(ss);
		
		
		
//		Arrays.stream(items)
//				.reduce(0, bf, bo);
			
		//System.out.println(x);
		
		Optional<Integer> red = Arrays.stream(items)
				.map(String::length)
				.reduce((a,b) -> a + b);
		
		System.out.println("All Strings size: " + red.get());
		

		
		Integer sum = Arrays.stream(items)
			.reduce(0, (a,b) -> a + b.length() , (c, d) -> c + d);

		
		System.out.println("All Strings size: " + sum);
		
		
		Integer sum2 = Arrays.stream(items)
				.map(elem -> elem.length())
				.reduce(0, (a,b) -> a + b);
			
			
			System.out.println("All Strings size: " + sum2);
			
			//Consumer<Integer> cons = (a) -> System.out.println(a);
			
			BiConsumer<String, Consumer<Integer>> bc = (string , consumer) -> System.out.println(string + " " + string.length()); 
			
		Arrays.stream(items)
			.mapMulti(bc)
			.forEach(s -> System.out.println(s));
		
		System.out.println("*******************");
		
		Arrays.stream(items)
			.mapMulti((a,b) ->  System.out.println(a + " " + a.length()))
			.forEach(s -> System.out.println(s + " " ));
		
		
		Arrays.stream(items)
			.mapMulti((elem , cons) ->  cons.accept(elem))
			.forEach(s -> System.out.println(s + " " ));
		
		System.out.println("\n************A2**********************************\n");
		
		
		/*
		 * ###### A2.
			Bilden Sie bitte eine Pipeline, die die Gesamtlänge aller Strings (Gesamtanzahl aller Zeichen) 
			aus folgendem Array berechnet. Verwenden Sie bitte die `reduce` mit drei Parameter. 

			String[] items = { "aa", "bbb", "cccc", "ddddd" };

			> Optional. Setzen Sie bitte wenn möglich KEINE intermediate Operations ein.

		 */
				
		Integer sum4 = Arrays.stream(items)
			.reduce(0, (a,b) -> a + b.length() , (c, d) -> c + d);
		
		System.out.println("All Strings size: " + sum4);
		
		
		System.out.println("\n************A3**********************************\n");
		
		
		/*
		 * ###### A3.

			Gegeben:

				Integer[] array = { 0, 0, 1, 0, 1, 0 };
	
				// hier identity, accumulator und combiner definieren
	
				String s = Stream.of(array)
					.reduce(identity, accumulator, combiner);
	
				System.out.println(s); // 001010

			Definieren Sie bitte die 'identity', 'accumulator' und 'combiner' so, 
			dass die Pipeline die Elemente des Arrays in Strings verwandelt und zu einem Gesamtstring konkateniert. 

		 */
		
		Integer[] array = { 0, 0, 1, 0, 1, 0 };
		
		Integer identity = 0;
		
		BiFunction<Integer, Integer, Integer> accumulator = (a,b) -> a+b;
		
		BinaryOperator<Integer> combiner = (a,b) -> a + b;
		
		Integer s = Stream.of(array)
				.reduce(identity,accumulator, combiner);

		//System.out.println(s); // 001010
			
			
		String identity2 = "";
			
		BiFunction<String, Integer, String> accumulator2 = (a,b) -> a.concat(b.toString());
			
		BinaryOperator<String> combiner2 = (a,b) -> a + b;
			
		String s2 = Stream.of(array)
					.reduce(identity2,accumulator2, combiner2);

		System.out.println(s2); // 001010
		
		String identity3 = "";
		
		BiFunction<String, Integer, String> accumulator3 = (a,b) -> a + b;
			
		BinaryOperator<String> combiner3 = String::concat;
			
		String s3 = Stream.of(array)
					.parallel()
					.reduce(identity3,accumulator3, combiner3);

		System.out.println(s3); // 001010


	}

}

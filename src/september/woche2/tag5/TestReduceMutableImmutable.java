package september.woche2.tag5;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TestReduceMutableImmutable {

	public static void main(String[] args) {

		
		String[] array = {"a","b","c","d","e"};
		
		/*
		 * Version 1
		 * Nachteil: bei einer grossen Datenmenge
		 * gibt es zu viele Konkatenationen
		 */
		
		String result1 =  Stream.of(array)
			.parallel()
			.reduce((s1, s2) -> s1 + s2)
			.get();
		
		System.out.println("Result1: " + result1);
		
		/*
		 * Version 2
		 * Idee: StringBuilder soll viele Konkatenationen vermeiden
		 * 
		 * Falsch ! Der Consumer in der Loesung aendert den Kontext!!!
		 */
		
		StringBuilder target = new StringBuilder();
		
		Stream.of(array)
			.parallel() // fuehrt zu falschen Ergegebnisse
			.forEach(s -> target.append(s));
		
		String result2 = target.toString();
		System.out.println("result2: " + result2);
		
		
		/*
		 * VErsion 3
		 */
		
		StringBuilder identity = new StringBuilder();
		
		BiFunction<StringBuilder, String, StringBuilder> acc = 
				(sb, elem) -> sb.append(elem);	// mutable reduction - append	
		
//		BinaryOperator<StringBuilder> cmb = (sb1, sb2) -> sb1.append(sb2);
		BinaryOperator<StringBuilder> cmb = (sb1, sb2) -> sb1;

		
		StringBuilder sbb = Stream.of(array)
				.parallel()
				.reduce(identity, acc, cmb);
		
//		StringBuilder sbb = Stream.of(array)
//				.reduce(identity, acc, cmb);
		
		String result3 = sbb.toString();
		
		System.out.println("Rsult3: " + result3);
		
		StringBuilder sb =  Stream.of(array)
			.parallel()
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		
		System.out.println("Collect: " + sb);
		
			
		
		
		/*
		 * Version 4
		 */
		
		
		BiFunction<StringBuilder, String, StringBuilder> accImm = 
				(prevBuilder, elem) -> {
					StringBuilder newBuilder = new StringBuilder();
					newBuilder.append(prevBuilder).append(elem);
					return newBuilder;
				};
		
		BinaryOperator<StringBuilder> combImm = (sb1, sb2) -> {
				StringBuilder newBuilder = new StringBuilder();
				newBuilder.append(sb1).append(sb2);
				return newBuilder;
		};
				
				
		StringBuilder resultBuilder = Stream.of(array)
				//.peek(s->System.out.println(s))
				.parallel()
				//.peek(s->System.out.println(s))
				.reduce(new StringBuilder(), accImm, combImm);
		
		String result4 = resultBuilder.toString();
		System.out.println("Result4: " + result4);
		
//		Stream.of(array)
//			.reduce(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		
		
	}

}

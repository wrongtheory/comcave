package september.woche3.tag3.Aufgaben;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import words.*;

public class WordsAufgabe {
	

	public static void main(String[] args) {

		Words w = new Words();
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("englishWords", w.englishWords());
		map.put("germanWords", w.germanWords());
		map.put("passwords", w.passwords());
		
		for(Map.Entry<String, List<String>> m : map.entrySet())
			System.out.println(m.getKey() + " contains " + m.getValue().size() + " words");
		
		System.out.println("********************A1******************************");
		a1(map);
		System.out.println("********************A2******************************");
		a2(map);
		System.out.println("********************A3******************************");
		a3(map);
		System.out.println("********************A4******************************");
		a4(map);
		System.out.println("********************A5******************************");
		a5(map);
		System.out.println("********************A6******************************");
		a6(map);
		System.out.println("********************A7******************************");
		a7(map);
		System.out.println("********************A8******************************");
		a8(map);






	

	}

	private static void a1(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			
			long count = m.getValue().stream()
				.filter(x -> x.length() > 5)
				.count();
			System.out.println(m.getKey() + " : Anzahl der Wörter mit der Länge größer als 5: " + count);
			
		}
	}

	private static void a2(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			
			//long count = 
					Optional<String> minw = m.getValue().stream()
						.filter(s -> s.startsWith("m"))
				.min(Comparator.naturalOrder());
			System.out.println(m.getKey() + " : lexikografisch kleinsten String liefert von den Strings, "
					+ "die mit 'm' starten: "+minw.get() );
			
		}

	}
	
	private static void a3(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			System.out.println(m.getKey() + " : die ersten 20 Wörter überspringt "
					+ "und dann die nächsten 10 Wörter ausgibt: ");
							m.getValue().stream()
						.skip(20)
						.limit(3).forEach(s -> System.out.println(s));
			
		}

	}
	private static void a4(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			long l = m.getValue().stream()
				.filter(s -> s.contains("ooo"))
				.count();
		System.out.println(m.getKey() + " : ob es mindestens ein Wort gibt in dem "
				+ "es den Unterstring 'ooo' gibt: " + l);
			
		}

	}
	
	private static void a5(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			LinkedList<String> list = m.getValue().stream()
				.filter(s -> s.contains("aba"))
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println(m.getKey() + " : die eine LinkedList liefert, in der alle Wörter gesammelt sind, "
				+ "die den Unterstring 'aba' beinhalten. : " + list.size());
			
		}

	}

	private static void a6(Map<String, List<String>> map) {
		String pass = "jordan";
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			boolean word = m.getValue().stream()
				//.filter(s -> s.equals("password"))
				.anyMatch(s -> s.equals(pass));
		System.out.println(m.getKey() + " : die überprüft ob es sich in der Liste "
				+ "der Passwörter ihr Lieblingspasswort befindet: " + word);
				
			
		}

	}
	
	private static void a7(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			
			Map<Integer, List<String>> mapLength = m.getValue().stream()
				.collect(Collectors.groupingBy(s -> s.length()));
		System.out.println(m.getKey() + " : Einer Gruppe werden Strings mit derselben Länge zugeordnet. "
				+ "Gruppen-ID (Key) ist die Länge der Gruppen-Strings: ");
				
		for(Integer len : mapLength.keySet()) {
			List<String> list = mapLength.get(len);
			System.out.format("Laege: %2d, Worter: %d %n", len, list.size());
		}
		}

	}
	
	private static void a8(Map<String, List<String>> map) {
		for(Map.Entry<String, List<String>> m : map.entrySet())
		{
			
			Map<Integer, Long> mapLength = m.getValue().stream()
				.collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
		System.out.println(m.getKey() + " : Einer Gruppe werden St1rings mit derselben Länge zugeordnet. "
				+ "Gruppen-ID (Key) ist die Länge der Gruppen-Strings: " + mapLength.get(m));
				
			for(Integer len : mapLength.keySet()) {
				Long l = mapLength.get(len);
				System.out.format("Laege: %2d, Worter: %d %n", len, l);
			}
		}

	}





}

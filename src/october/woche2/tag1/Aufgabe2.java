package october.woche2.tag1;

import java.io.*;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aufgabe2 {

	public static void main(String[] args) {

		System.out.println("********************A1*****************************");
		//a1();
		System.out.println("\n******************A2*****************************");
		try {
		a2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void a1() {
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
	}

	private static void a2() throws IOException {

		List<String> list = new ArrayList<>();
		
		Function<String, String> classifier = (String x) -> {
			return x.contains("/") ? x.substring(0, x.indexOf("/")) : "Special";
		};

		Map<String, TreeSet<String>> map1 = ZoneId.getAvailableZoneIds().stream()
				.collect(Collectors.groupingBy(classifier, TreeMap::new, Collectors.toCollection(TreeSet::new)));

		for (Map.Entry<String, TreeSet<String>> map : map1.entrySet()) {
			System.out.println("\nGruppe '" + map.getKey() + "':\n");
			File file = new File(map.getKey().toString());
			for (String s : map.getValue()) {
				System.out.println("\t" + s);
				list.add(s);
			}
			writeFile(list, file);	
			list.clear();
			
		}
	}
	
	public static void writeFile(List<String> data, File destination) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
			for(String s: data) {
				writer.write(s);
				writer.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

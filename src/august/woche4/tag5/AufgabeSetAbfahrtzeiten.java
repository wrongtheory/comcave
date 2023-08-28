package august.woche4.tag5;

import java.util.NavigableSet;
import java.util.TreeSet;

public class AufgabeSetAbfahrtzeiten {

	public static void main(String[] args) {
		
		NavigableSet<String> zeiten =  getAbfahrrtzeiten();
		
		System.out.println(zeiten);
		
		System.out.println("suchen Sie die erste Abfahrtzeit nach 12:03");
		
		String result = zeiten.higher("12:03");
		System.out.println("Result: " + result);

		System.out.println("suchen Sie die erste Abfahrtzeit vor 12:03");
		
		result = zeiten.lower("12:03");
		System.out.println("Result: " + result);
		
		System.out.println("suchen Sie die erste Abfahrtzeit nach 17:12 inklusive");
		
		result = zeiten.ceiling("17:12");
		System.out.println("Result: " + result);
		
		System.out.println("suchen Sie die erste Abfahrtzeit nach 17:12 exklusive");
		
		result = zeiten.higher("17:12");
		System.out.println("Result: " + result);
		
		System.out.println("Suchen sie nach Alle Abfahrtzeiten zwischen 12:00 und 13:00");
		
		NavigableSet<String> subset =  zeiten.subSet("12:00", true, "13:00", true);
		
		System.out.println(subset);
		
		System.out.println("11:52 exklusive und 13:12 inklusive");
		subset =  zeiten.subSet("11:52", false, "31:12", true);
		System.out.println(subset);
		
		result = zeiten.first();
		System.out.println(result);
		
		result = zeiten.last();
		System.out.println(result);
		
	}

	 static NavigableSet<String> getAbfahrrtzeiten() {
		 NavigableSet<String> set = new TreeSet<>();
		
		 for(int stunde = 6; stunde < 24; stunde++) {
			// System.out.println("stunde: " + stunde);
			 
			 for(int minute = 12; minute < 60; minute+=20) {
				 String zeit = String.format("%02d:%02d", stunde, minute);
				 set.add(zeit);
			 }
		 }
		 
		return set;
	}

}

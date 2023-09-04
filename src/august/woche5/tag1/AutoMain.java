package august.woche5.tag1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.TableColumnModelListener;

public class AutoMain {

	public static void main(String[] args) {
		
		System.out.println("===================A1============================");
		System.out.println("Erstellen Sie eine abstrakte Klasse 'Auto' und die Klassen 'VW' und 'BMW' nach folgendem Klassendiagramm");
		
		System.out.println("===================A2============================");
		System.out.println("Erstellen Sie eine Instanz vom Typ VW (Golf, Baujahr 1990) und eine Instanz vom Typ BMW (Z4, Baujahr 2000).\n");
		
		VW vw = new VW("Golf", 1990);
		BMW bmw = new BMW("Z4", 2000);
		
		System.out.println(vw);
		System.out.println(bmw);
		
		System.out.println("===================A3============================");
		System.out.println("Erstellen Sie 3 Instanzen von VW.");
		
		VW[] vws = {
				new VW("Tiguan", 2004),
				new VW("Tiguan", 2004),
				new VW("Arteon", 2010),
				new VW("Arteon", 1989),
				new VW("Arteon", 2007),
				new VW("Polo", 1990)	
		};
		
		System.out.println("===================A4============================");
		System.out.println("Speichern Sie die 3 VW-Referenzen in LinkedList, HashSet, TreeSet und PriorityQueue"
				+"\nBeim Sortieren sollen die Objekte erst nach dem Modell und dann nach dem Baujahr verglichen werden"
				+"\nDie ggf. notwendige(n) hashCode-Methode(n) soll(en) korrekt (richtig, gültig) aber nicht unbedingt sinnvoll implementiert werden.");
		
		List<VW> linkedListVW = new LinkedList<>(Arrays.asList(vws));
		Collections.sort(linkedListVW);

		Set<VW> hashSetVW = new HashSet<>(linkedListVW);
		Set<VW> treeSetVW = new TreeSet<>(linkedListVW);
		Queue<VW> priorityQueueVW = new PriorityQueue<>(linkedListVW);
		
		System.out.println("===================A5============================");
		System.out.println("Geben Sie alle erstellten Collections mit den foreach-Schleifen aus.\n");
		
		System.out.println("===================sorted LinkedList============================");
		print(linkedListVW);
		
		System.out.println("===================sorted HashSet????============================");
		print(hashSetVW);
		
		System.out.println("===================sorted TreeSet============================");
		print(treeSetVW);
		
		System.out.println("===================sorted PriorityQueue============================");
		print(priorityQueueVW);
		
		System.out.println("===================A6============================");
		System.out.println("Erstellen Sie 2 Objekte von Typ 'BWM'"
				+"\nSpeicher Sie die Referenzen in ArrayList, HashSet, TreeSet und ArrayDeque"
				+"\nGeben Sie die neu erstellten Collections aus\n");
		
		
		BMW bmw1 = new BMW("X5 Serie", 2010);
		BMW bmw2 = new BMW("X6 Serie", 2004);
		BMW bmw3 = new BMW("X6 Serie", 2004);
		BMW bmw4 = new BMW("X5 Serie", 1989);

		List<BMW> arrayListBMW = new ArrayList<>();
		
		arrayListBMW.add(bmw1);
		arrayListBMW.add(bmw2);
		arrayListBMW.add(bmw3);
		arrayListBMW.add(bmw4);
		
		Collections.sort(arrayListBMW);

		Set<BMW> hashSetBMW = new HashSet<>(arrayListBMW);	
		Set<BMW> treeSetBMW = new TreeSet<>(arrayListBMW);
		Queue<BMW> arrayDequequeueBMW = new ArrayDeque<>(arrayListBMW);		
		
		System.out.println("===================sorted ArrayList============================");
		print(arrayListBMW);
		
		System.out.println("===================sorted HashSet???============================");
		print(hashSetBMW);
		
		System.out.println("===================sorted TreeSet============================");
		print(treeSetBMW);
		
		System.out.println("===================sorted ArrayQueue============================");
		print(arrayDequequeueBMW);
		
		System.out.println("===================A7============================");
		System.out.println("Benutzen Sie die Methode 'contains', um in dem HashSet von BMW-Objekten nach bmw1 zu suchen.\n");
		
		//System.out.println("Contains HashSet 'BMW X5 Serie 2010' ? " + hashSetBMW.contains(new BMW("X5 Serie", 2010)));
		System.out.println("HashSet contains bmw1 ? : " + hashSetBMW.contains(bmw1));
		
		System.out.println("===================A8============================");
		System.out.println("Fügen Sie der Klasse BMW die Setter-Methode für das Attribut 'baujahr' hinzu."  
				+ "\nBenutzen Sie die neue Methode mit der Referenz bmw1 um das Baujahr zu ändern."
				+"\nVersuchen Sie erneut mit der Methode 'contains' in dem HashSet von BMWs nach bmw1 zu suchen. "
				+ "\nWas liefert die Methode 'contains' und warum?\n\n");
		
		// value baujahr which is used in the hashCode method was changed
		bmw1.setBauJahr(3000);
		System.out.println("HashSet contains bmw1 ? : " + hashSetBMW.contains(bmw1));
		
		//temporarily remove bmw1 from the set
		hashSetBMW.remove(bmw1);
		// set bmw baujahr
		bmw1.setBauJahr(3000);
		// add bmw again to the HashSet
		hashSetBMW.add(bmw1);

		System.out.println("HashSet contains bmw1 ? : " + hashSetBMW.contains(bmw1));
		
		System.out.println("===================A9============================");
		System.out.println("Erstellen Sie eine Instanz VW (Polo, Baujahr 2200) und speichern Sie ihre Adresse in der Liste mit VWs. "
				+ "Speichern Sie dabei die Adresse in keiner weiteren Referenz.");
		
		VW vwpolo = new VW("Polo", 2200);
		linkedListVW.add(vwpolo);
		
		System.out.println("===================A10============================");
		System.out.println("Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 2200 in der Liste aus A9. "
				+ "\nGeben Sie das Ergebnis aus.\n");
		
		int search1 = Collections.binarySearch(linkedListVW, new VW("Polo", 2200));
		System.out.println("linkedListVW is not sorted! " + search1);
		
		Collections.sort(linkedListVW);
		int search2 = Collections.binarySearch(linkedListVW, new VW("Polo", 2200));
		System.out.println("VW Polo 2200 is at index: " + search2);
		
		System.out.println("===================A11============================");
		System.out.println("Benutzen Sie die Methode 'sort' aus der Klasse 'Collections' um die Liste mit VWs zu sortieren. "
				+ "\nGeben Sie die sortierte Liste aus.\n");
		
		for(VW vww : linkedListVW)
			System.out.println(vww);
		
		System.out.println("===================A12============================");
		System.out.println("Benutzen Sie die Methode 'sort' aus der Klasse 'Collections' um die Liste mit VWs in der Umkehrreihenfolge zu sortieren. "
				+ "\nGeben Sie die Liste aus.\n");

		Comparator<VW> comp = Comparator.comparing(VW::getModell).thenComparing(VW::getBaujahr).reversed();
		Collections.sort(linkedListVW, comp);
		
		for(VW vww : linkedListVW)
			System.out.println(vww);
		
		System.out.println("===================A13============================");
		System.out.println("Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 2200 in der Liste mit VWs. "
				+ "\nGeben Sie das Ergebnis aus.\n");
		
		int search3 = Collections.binarySearch(linkedListVW, new VW("Polo", 2200));
		System.out.println("linkedListVW is not sorted!: " + search3);
		
		Collections.sort(linkedListVW);
		int search4 = Collections.binarySearch(linkedListVW, new VW("Polo", 2200));
		System.out.println("VW Polo 2200 is at index: " + search4);
		
		System.out.println("===================A14============================");
		System.out.println("Benutzen Sie die Methode 'binarySearch' aus der Klasse 'Collections' und suchen Sie nach einem VW Polo, Baujahr 3300 in der Liste mit VWs. "
				+ "\nGeben Sie das Ergebnis aus.\n");
		
		int search5 = Collections.binarySearch(linkedListVW, new VW("Polo", 3300));
		System.out.println("Polo 3300 is not in the List!: " + search5);
		
	}
	
	public static void print(Collection<? extends Auto> autos) {
		for(Auto auto : autos)
			System.out.println(auto);
	}

}

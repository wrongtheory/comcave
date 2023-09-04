package august.woche5.tag1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import august.woche3.aufgaben.Besitzer;

public class AufgabeMap {

	public static void main(String[] args) {
		
		Fahrzeug f1 = new Fahrzeug("123", "BMW");
		Fahrzeug f2 = new Fahrzeug("456", "Audi");
		Fahrzeug f3 = new Fahrzeug("789", "Opel");
		Fahrzeug f4 = new Fahrzeug("222", "Mercedes");
		
		Person p1 = new Person("Johny", "Depp");
		Person p2 = new Person("Vasea", "Mure");
		Person p3 = new Person("Victor", "Leunti");
		
		List<Fahrzeug> listp1 = new ArrayList<>();
		List<Fahrzeug> listp2 = new ArrayList<>();
		List<Fahrzeug> listp3 = new ArrayList<>();
		
		listp1.add(f1);
		listp2.add(f2);
		listp3.add(f4);
		listp1.add(f4);
		
		Map<Fahrzeug, Person> map = new HashMap<>();
		Map<Person, List<Fahrzeug>> map2 = new HashMap<>();
		
		
		
		
		map.put(f1, p1);
		map.put(f2, p2);
		map.put(f3, p3);
		map.put(f4, p1);
		
		map2.put(p1, listp1);
		map2.put(p2, listp2);
		map2.put(p3, listp3);

		
		System.out.println(f1 + " gehort zu  " + map.get(f1));
		
		System.out.println(map2.get(p1));
		
		
		
//		for(Map.Entry<Fahrzeug, Person> m : map.entrySet()) {
//			Fahrzeug f = m.getKey();
//			Person p = m.getValue();
//			System.out.println(f + " gehort zu " + p);
//		}
		

	}

}

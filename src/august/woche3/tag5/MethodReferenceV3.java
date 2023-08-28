package august.woche3.tag5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceV3 {
	
	//Methodenreferenz ist auch aeine sehr kompakte Lambda
	
	//Referenz auf eine Instanzmethode eines vorhandenen Objektes
	//(Reference to an instane method of a particular Object
	
	//Voraussetzungen:
	
	//1.Die Realisierung der abstrakten Methode besteht aus einer einzigen Anweisung

	//2.Diese Anweisung ist der Aufruf einer Instanzmethode mit einem vorhandenen Objekt
	//(oder die return mit dem Aufruf einee Instanzmethoden
	
	//3.Alle Parameter der zu realizierenden abstrakten Methode werden als Argumente
	//an den aufgerufene Instanzmethode ubergeben
	


	public static void main(String[] args) {
		
		String obj = "Java"; // das vorhandene Objekt
		
		// mit einer anonymen Klasse
		
		UnaryOperator<String> op1 = new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				return obj.concat(t);
			}
		};
		
		System.out.println(op1.apply(" ist toll"));
		
		// mit einer normale Lambda
		
		UnaryOperator<String> op2 = s -> obj.concat(s);
		System.out.println(op2.apply(" ist toll"));
		
		// mit einer Methodenreferenz
		
		UnaryOperator<String> op3 = obj::concat;
		System.out.println(op3.apply(" ist toll"));
		
		//es darf auch eine anonyme referenz sein:
		Supplier<String> s1 = new Object()::toString;
		Object obj2 = new Object();
		Supplier<String> s2 = obj2::toString;
		
		s1.get();

	}
	
	static void kleineAufgabe() {
		Integer x = 12;
		// Predicate<Integer> p1 = x::intValue; // cf
		
//		class Bla implements Predicate<Integer> { // cf
//			public boolean test(Integer p) {
//				return x.intValue();
//			}
//		}
	}
	
	static void kleineAufgabe2() {
		List<Number> list = new ArrayList<>();
		
		Predicate<Integer> p1 = list::add;
		
		class Bla implements Predicate<Integer> {
			public boolean test(Integer p) {
				return list.add(p);
			}
		}
	}
	
	static void kleineAufgabe3() {
		String obj = "ja";
	//	Supplier<String> s1 = obj::concat; // cf
		
	}

}

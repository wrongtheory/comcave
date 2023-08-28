package august.woche3.tag5;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReferenceV4 {
	

	//Methodenreferenz ist auch aeine sehr kompakte Lambda
	
	//Referenz auf eine Instanzmethode eines unbestimmten Objektes
	//eines bekannten Types
	//(Reference to an instane method of an arbitrary Object of a particular type
	
	// Anders formuliert: 
	//Referenz auf eine Instanzmethode des 1.Parameters der abstrakten Methode
	//die realisiert wird
	
	
	//Voraussetzungen:
	
	//1.Die Realisierung der abstrakten Methode besteht aus einer einzigen Anweisung

	//2.Diese Anweisung ist der Aufruf einer Instanzmethode zu dem 1.Parameter
	//der zu realisierenden Methode
	//(oder die return mit dem Aufruf der Instanzmethoden des 1.parameter
	
	//3.Alle weiteren Parameter der zu realizierenden abstrakten Methode werden als Argumente
	//an den aufgerufene Instanzmethode ubergeben

	public static void main(String[] args) {
		
		BinaryOperator<String> bf1 = new BinaryOperator<String>() {
			
			@Override
			public String apply(String t, String u) {
				
				return t.concat(u);
			}
		};
		
		BinaryOperator<String> bf2 = (a,b) -> a.concat(b);
		
		BinaryOperator<String> bf3 = String::concat;

	}
	
	static void kleineAufgabe() {
		//da es hier zwei varianten der methodenreferenz geben kann
		//version 1 und version 4 da die klasse integer
		//sowohl eine passeende statische toString als auch eine
		//instanzmethode toString hat.
		
		//Function<Integer, String> f1 = Integer::toString;
		
		Function<Integer, String> f2 = a -> a.toString();
		
		
		
		
		class BlaA implements Function<Integer, String> {
			public String apply(Integer i) {
				return Integer.toString(i); //static toString method
			}
		}
		
		class BlaB implements Function<Integer, String> {
			public String apply(Integer i) {
				return i.toString(); // instance toString method
			}
		}
	}
	
	static void kleinesBeispiel() {
		
		UnaryOperator<Integer> op = Integer::intValue;
		
		class Bla implements UnaryOperator<Integer> {
			public Integer apply(Integer p) {
				return p.intValue();
			}
		}
		
		
	}

}

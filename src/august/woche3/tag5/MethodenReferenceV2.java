package august.woche3.tag5;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodenReferenceV2 {

	//Methodenreferenz ist auch aeine sehr kompakte Lambda
	
		//Referenz auf einem Konstruktor
		
		//Voraussetzungen:
		
		//1.Die Realisierung der abstrakten Methode besteht aus einer einzigen Anweisung
	
		//2.Diese Anweisung ist der Aufruf einers Konstruktors mit new
		//(oder die return mit dem Aufruf eines Konstruktors
		
		//3.Alle Parameter der zu realizierenden abstrakten Methode werden als Argumente
		//an den aufgerufene Konstruktor ubergeben
		
	public static void main(String[] args) {
		
		// mit einer anonymen Klasse
		Supplier<StringBuilder> s1 = new Supplier<StringBuilder>() {
			
			@Override
			public StringBuilder get() {
				return new StringBuilder();
			}
		};
		
		StringBuilder sb1 = s1.get();
		
		//mit einer normalen Lambda
		
		Supplier<StringBuilder> s2 = () -> new StringBuilder();
		StringBuilder sb2 = s1.get();
		
		//mit einer methodreferenz
		
		Supplier<StringBuilder> s3 = StringBuilder::new;
		StringBuilder sb3 = s3.get();

	}
	
	static void kleineAufgabe() {
		Function<String, StringBuilder> f1 = StringBuilder::new;
		Function<StringBuilder, String> f2 = String::new;
		
		class Bla implements Function<StringBuilder, String> {
			public String apply(StringBuilder p) {
				return new String();
			}
		}
	}
	
	static void kleineAufgabe2() {
		Consumer<String> c1 = StringBuilder::new;
		
		class Bla implements Consumer<String> {
			public void accept(String s) {
				new StringBuilder(s);
			}
		}
		
	}
	
	static void kleineAufgabe3() {
		//Supplier<String> c1 = StringBuilder::new;
		
		class Bla implements Supplier<String> {
			public String get() {
				return new String();
			}
		}
		
	}
	
	Supplier<StringBuilder> c1 = StringBuilder::new;
	//Supplier<StringBuilder> c2 = String::new;

}

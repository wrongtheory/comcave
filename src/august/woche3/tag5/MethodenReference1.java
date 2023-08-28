package august.woche3.tag5;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodenReference1 {
	
	//Methodenreferenz ist auch aeine sehr kompakte Lambda
	
	//Referenz auf eine statische Methode
	
	//Voraussetzungen:
	
	//1.Die Realisierung der abstrakten Methode besteht aus einer einzigen Anweisung
	//2.Diese Anweisung ist der Aufruf einer statischenn Methode
	//(oder die return mit dem Aufruf einer staischen Methode
	
	//3.Alle Parameter der zu realizierenden abstrakten Methode werden als Argumente
	//an die aufgerufene statische Methode ubergeben
	

	public static void main(String[] args) {
		
		//mit einer anonyme Klasse
		Supplier<Double> s1 = new Supplier<Double>() {
			
			@Override
			public Double get() {
				return Math.random();
			}
		};
		
		Double d1 = s1.get();
		System.out.println("s1.get(): " + d1);
		
		// mit einer normale Lamda
		
		Supplier<Double> s2 = () -> Math.random();
		Double d2 = s1.get();
		System.out.println("s2.get(): " + d2);
		
		//mit der Methodenreferenz
		
		Supplier<Double> s3 = Math::random;
		
		Double d3 = s3.get();
		System.out.println("s3.get(): " + d3);
		
		kleineAufgabe();
	}
	
	static void kleineAufgabe() {
		Function<String, Integer> f2 = Integer::valueOf;
		Function<String, Integer> f3 = (a) -> Integer.valueOf(a);
		System.out.println(f3.apply("123"));
		
		class Bla implements Function<String, Integer> {
			public Integer apply(String param) {
				return Integer.valueOf(param);
			}
		}
	}
	
	static void kleineAufgabe2() {
		//Supplier<String> s1 = String::concat; // cf
		
		String s = "";
		s.concat("");
		
//		class Bla implements Supplier<String> {
//			public String get() {
//				//return String.concat; // cf es gibt keine statishce cancat
//			}
//		}

	}
	
	static void kleineAufgabe3() {
		Supplier<LocalDate> s1 = LocalDate::now;
		
		class Bla implements Supplier<LocalDate> {
			public LocalDate get() {
				return LocalDate.now();
			}
		}
	}

}

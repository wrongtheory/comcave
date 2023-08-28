package august.woche3.aufgaben;

import java.util.function.BiFunction;
import java.util.function.Function;


public class Main {
	
	public static Auto[] auto = {
			new Auto("BMW", "rot", 2009),
			new Auto("Mercedes", "gelb", 2015),
			new Auto("Audi", "schwarz", 2019),
			new Auto("Porsche", "grun", 2000)
	};
	
	
	
	public static Besitzer[] besitzers = {
			//new Besitzer("John", 29, auto[2]),
			new Besitzer("Erik", 45),
			new Besitzer("mark", 55),
			new Besitzer("Elon", 47)
	};

	public static void main(String[] args) {
		
		//auto[0].setBesitzer(0);
		
		//System.out.println(auto[0].getBesitzer());
		
		
		
		// sell an auto
		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<Auto, Integer, Besitzer>() {
			
			// anonyme klasse
			@Override
			public Besitzer apply(Auto t, Integer u) {
				
				return t.kaufAuto(t, u);
			}
		};
		
		// sell an auto to erik
		f1.apply(auto[0], 0);

		
		//System.out.println(f2.apply(auto[0], 1));
//		BiFunction<Auto, Integer, Besitzer> f3 = (a,i) -> a.getBesitzer(); 
//		System.out.println(f3.apply(auto[0], 9));

		//show the Car Owner
		System.out.println(auto[0].getBesitzer() + " besitzt an " + besitzers[0].getAuto());
		
		//sell an auto to mark
		BiFunction<Auto, Integer, Besitzer> f2 = (a,i) -> a.kaufAuto(a, i);
		f2.apply(auto[3], 1);
		System.out.println(auto[3].getBesitzer() + " besitzt an  " +  besitzers[1].getAuto());
		
		BiFunction<Auto, Integer, Besitzer> f3 = Auto::kaufAuto;
		f3.apply(auto[2], 2);
		System.out.println(auto[2].getBesitzer() + " besitzt an  " +  besitzers[2].getAuto());

		BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
		f4.apply(auto[2], 1);
		System.out.println(f4.apply(auto[2], 2));
		
		/*
		 * f1.apply(auto[1], 1); System.out.println(f1.apply(auto[1], 3));
		 * 
		 * BiFunction<Auto, Integer, Besitzer> f2 = (a,b) -> a.findBesitzer(a,b);
		 * System.out.println(f2.apply(auto[0], 2));
		 * 
		 * BiFunction<Auto, Integer, Besitzer> f3 = Auto::findBesitzer;
		 * System.out.println(f3.apply(auto[1], 3));
		 * 
		 * BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
		 * System.out.println(f4.apply(auto[1], 1));
		 */
	}
	
	static void kleineAufgabe() {
		//BiFunction<Auto, Integer,Besitzer> f2 =Auto::getBesitzer;
		//Function<String, Integer> f3 = (a) -> Integer.valueOf(a);
		//System.out.println(f3.apply("123"));
		
		class Bla implements BiFunction<Auto, Integer,Besitzer> {
			public Besitzer apply(Auto a, Integer i) {
				return a.getBesitzer();
			}
		}
	}
	

}

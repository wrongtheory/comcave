package august.woche.tag1.methodref.copy;

import java.util.function.BiFunction;


public class AufgabeBiFunctionMethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiFunction<Auto2, Integer, Besitzer2> f1 = new BiFunction<Auto2, Integer, Besitzer2> (){
			@Override
			public Besitzer2 apply(Auto2 t, Integer u) {
				// TODO Auto-generated method stub
				return new Besitzer2(t, u);
			}
		};
		
		//A1
		Besitzer2 b1 =  f1.apply(new Auto2(), 1);
		System.out.println(b1);
		
		//A2
		BiFunction<Auto2, Integer, Besitzer2> f2 = (a, id) -> new Besitzer2(a, id);
		Besitzer2 b2 = f2.apply(new Auto2(), 2);
		System.out.println(b2);
		
		//A3
		BiFunction<Auto2, Integer, Besitzer2> f3 = Besitzer2::createInstance;
		Besitzer2 b3 = f3.apply(new Auto2(), 3);
		System.out.println(b3);
		
		//A4
		
		BiFunction<Auto2, Integer, Besitzer2> f4 = Besitzer2::new;
		Besitzer2 b4 = f4.apply(new Auto2(), 4);
		System.out.println(b4);
		
		//A5
		BesitzerBuilder builder = new BesitzerBuilder();
		BiFunction<Auto2, Integer, Besitzer2> f5 = builder::build;
		Besitzer2 b5 = f5.apply(new Auto2(), 5);
		System.out.println(b5);
		
		//A6
		BiFunction<Auto2, Integer, Besitzer2> f6 = Auto2::createBesitzer;
		Besitzer2 b6 = f6.apply(new Auto2(), 6);
		System.out.println(b6);
	}

}

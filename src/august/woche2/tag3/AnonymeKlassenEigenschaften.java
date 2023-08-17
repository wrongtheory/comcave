package august.woche2.tag3;

import java.time.Year;
import java.util.ArrayList;
import java.util.function.Predicate;

class Dozent{
	public Dozent(String name) {
	}
	
	Dozent(int id){
		
	}
}

public class AnonymeKlassenEigenschaften {

	public static void main(String[] args) {

		//Year year1 = Year.of(1980);
		//Year year2 = Year.of(2023);
		//System.out.println(year1);
		for(int i = Year.of(0).getValue(); i <= Year.of(2023).getValue(); i++) {
			System.out.println(i+ " " + Year.isLeap(i));
		}
		
		
		new Predicate<String>() {

			@Override
			public boolean test(String s) {
				// TODO Auto-generated method stub
				return true;
			}
			
		};
		
		new ArrayList<String>() {
			
		};
		
		new Object() {
			
		};
		
		//new String() {}; // cf: final
		
		new Dozent("Tom") {};
		new Dozent(1213) {};
		
		
		ArrayList<Integer> ref = new ArrayList<Integer>() {
			int att = 33;
			
			public boolean add(Integer i) {
				System.out.println(att);
				myMethod();
				return super.add(i);
			}
			
			void myMethod() {
				
			}
			
			void testCall() {
				
			}
		};
		vglMitLambda();
	}
		// ref.myMethod();  // cf
		
		static void vglMitLambda() {
			
			Predicate<Integer> p1 = new Predicate<Integer>() {
				
				public boolean test(Integer i) {
					System.out.println(this);
					System.out.println("this " + this.getClass());
					return true;
				}
			};
			
			System.out.println(p1.getClass());
			p1.test(33);
			
			Predicate<Integer> p2 = i -> {
				// System.out.println(this); //cf
				return true;
			};
			
			System.out.println(p2.getClass());
	}
		
	

}

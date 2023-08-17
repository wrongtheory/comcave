package august.woche2.tag3.functionalInterfaces;

import java.util.function.Predicate;

public class LambdaSyntax {
	
	interface I1 {
		void m();
	}

	interface I2 {
		void m(int x);
	}
	
	interface I3 {
		void m(int x, String y);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		I1 i1 = () -> {};
		I2 i2 = (int param) -> {};
		
		I3 i3 = (int a, String b) -> {};
		
		I2 i22 = (p) -> {};
		I3 i33 = (a,b) -> {};
		
		I1 v1 = () -> {};
		
		I2 v2 = p -> p++;
		
		Predicate<Integer> p1 = i -> {
			int x = i * 2;	
			return x > 100;
		};
		
		I1 r1 = () -> System.out.println("moin");
		
		
		
		Predicate<Integer> p22 = i -> i > 0;
		System.out.println(p22.test(1));
		usePredicate(i -> i > 0);
		
		usePredicate(i -> i > 0);
		
		
		
	}
	
	static void usePredicate(Predicate<Integer> p) {
		
	}

}

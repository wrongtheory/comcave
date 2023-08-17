package august.woche2.tag3.functionalInterfaces;

public class FunctionalInterfaceAnnotation {
	
//	@FunctionalInterface
//	interface I1 { cf : kein funk interface
		

	interface I2{
		void m2(); // funk interface
	}
	
	@FunctionalInterface
	interface I3 {
		void m3();
	}
	
	interface I4 {
		String toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package august.woche2.tag3.functionalInterfaces;

public class FunctionalInterface1 {
	
	interface I1 {} // keine funk interface
	
	interface I2{  // funk Interface
		void m();
	}
	
	interface I3{  // funk Interface
		String getString();
	}
	
	interface I4{  // keine funk Interface
		String toString();
	}
	
	interface I5{  //  funk Interface
		String toString(); // uberschriebene von objekt nicht abstract
		int hashCode();   // uberschriebene von objekt nicht abstract
		boolean equals(Object param); // uberschriebene von objekt nicht abstract
		default void m1() {} // nicht abstract
		void m2(); // abstract
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//I1 = () -> {} // cf
		
		I1 ii1 = new I1() {};
		
		I2 i2 = () -> {};
		
		I3 i3 = () -> "Moin";
		
		//I4 i4 = () -> "Moin"; // cf: keine funk Interface
	}

}

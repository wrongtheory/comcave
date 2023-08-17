package august.woche2.tag3;


class Outer{
	
	static int staticAtt = 1;
	int att = 2;
	
	static Object staticObj = new Object() {
			void testAccess() {
				System.out.println(Outer.staticAtt);
				//System.out.println(Outer.this.att); // cf
			}
	};
	
	 Object staticObj2 = new Object() {
		void testAccess() {
			System.out.println(Outer.staticAtt);
			System.out.println(Outer.this.att); // cf
		}
};
	
	static class StaticInner { // static (inner, nested) member class
		void testAccess() {
			System.out.println(Outer.staticAtt);
			// System.out.println(Outer.this.att); //cf
		}
	}
	
	class Inner { // non-static (inner, nested) member class 
		void testAccess() {
			System.out.println(Outer.staticAtt);
			System.out.println(Outer.this.att);
		}
	}
	
	//Methoden der Klasse Outer
	
	static void StaticMethod() {
		class LocalClass { // static inner local
			void testAccess() {
				System.out.println(Outer.staticAtt);
				// System.out.println(Outer.this.att); // cf
			}
		}
		
		new Object() {
			void testAccess() {
				System.out.println(Outer.staticAtt);
				//System.out.println(Outer.this.att);
			}
		};
	}
	
	void method() {
		class LocalClass { // non static inner class
			void testAccess() {
				System.out.println(Outer.staticAtt);
				System.out.println(Outer.this.att);
			}
		}
		
		new Object() {
			void testAccess() {
				System.out.println(Outer.staticAtt);
				System.out.println(Outer.this.att);
			}
		};
	}
	

	
	
} // end of class Outer

public class ArtenDerInnerenKlassen {

	public static void main(String[] args) {
		
		new Outer.StaticInner();
		
		// new Outer.Inner() // cf
		new Outer().new Inner();

	}

}

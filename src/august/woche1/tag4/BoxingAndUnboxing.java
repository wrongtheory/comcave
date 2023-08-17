package august.woche1.tag4;

public class BoxingAndUnboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//--------Boxing-------///
		int a = 50;
		
		Integer a3 = 5; // Boxing 
						//Automatic conversionof primitive data type
						// into a Wrapper type
		
		Integer a2 = new Integer(a); // Boxing

		//-------Unboxing--------//
		
		Integer i = new Integer(50);
		int b = i; // Unboxing - Automatic conversion of wrapper class type into
					// corresponding primitive type
		
		//--------Autoboxing=-------//
		
		Integer i2 = new Integer(50);
		
		if(i2 < 100) 					// unboxing internally - autounboxing can be performed
		System.out.println(i2);			//with comparison operators
		
		
		
		short s = 30;
		m(s); // prints 'int' , widening beats boxing
		
		short s1 = 30, s2 = 40;
		
		m(s1,s2); // prints 'int int' widening beats var-args
		
		int a4 = 30;
		
		m(a); // prints 'int' - boxing beats var-args
		
		int a5 = 30;
		
		m(a);
	}
	
	static void m(int i) {System.out.println("int");}
	static void m(Integer i) {System.out.println("Integer");}
	static void m(int i, int i2) {System.out.println("int int");}
	static void m(Integer...i) {System.out.println("Integer..");}
	static void m(Long l) {System.out.println("Long");}

}

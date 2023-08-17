package august.woche1.tag3;

interface BaseInterface {
	public static void m1() {}
	public static final int k1 = 1;
	public void m3();
}

class BaseClass {
	public static void m2() {}
	public static final int k2 = 1;
}

class DerivedClass extends BaseClass implements BaseInterface{
	public void m3() {}
	void testCall() {
		System.out.println(k1);
		System.out.println(k2);
		m2();
		BaseInterface.m1();
	}
}


public class StatischeMethodeAufrufen {
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DerivedClass.m2();
		//DerivedClass.m1(); // cf
		BaseInterface.m1();
		
		System.out.println(DerivedClass.k1);
		System.out.println(DerivedClass.k2);
		System.out.println(BaseInterface.k1);
		new DerivedClass().m3();
		
		BaseClass ref1 = null;
		ref1.m2();
		
		DerivedClass ref2 = null;
		ref2.m2();
		
		BaseInterface ref3 = null;
		ref3.m3();
		
		
		
	}

}

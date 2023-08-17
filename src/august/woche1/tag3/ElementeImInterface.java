package august.woche1.tag3;

interface MyInterface {
	void m1();
	public abstract void m2();
	
	default void m5() {}
	
	private void m6() {}
	
	static void m7() {}
	
	private static void m81() {}
	
	//int k0; // cf statische Konstante muss initialisiert werden
	int k1 = 1; // public static final
	
	public abstract static class InnerClass {}
	interface InnerInterface {}
	enum InnerEnum {}
	@interface 
	InnerAnnotation {}
	
	
}


public class ElementeImInterface {
	
	@Override
	public String toString() {
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MyInterface.k1);
		
	
		
		
	}

}

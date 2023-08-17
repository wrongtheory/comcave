package august.woche1.tag2;

class MyBase {
	int att =22;
	static void hello() {
		System.out.println("hello1");
	}
}

class MyDerived extends MyBase {
	
	int att =777;
	
	static void hello() {
		System.out.println("hello2");
	}
	static void testAccess() {
		// super.hello(); // cf
		
		
	}
	
	void testAccess02() {
		super.hello();
		this.hello();
		hello();
		
		System.out.println(att);
		System.out.println(this.att);
		System.out.println(super.att);
		super.hello();
		
		
	}
	
}

public class ThisUndSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyDerived().testAccess02();
	
	
	}

}

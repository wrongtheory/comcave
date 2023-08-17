package august.woche1.tag3;

interface I1 {
	
}

class C1 implements I1 {}

interface I2 {
	void m();
}

interface I3 extends I2 {}

class C2 implements I3 {
	public void m() {}
}

class C3 implements I3{
	public void m() {}
}

public class InterfacesDefinierenUndImplementieren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}

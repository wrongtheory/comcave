package august.woche1.tag2;

class MyClass {
	static int v1;
	// static final int k1; // cf
	//final int f;
	static final int k2 = 2;
	
	static final int k3;
	
	static {
		k3 = 3;
	}
	
	int v2;
	// final int k1; //cf 
	
	final int k4 = 2;
	
	final int k5;
	
	{
		k5 = 3;
	}
	
	final int z1;
	
	public MyClass() {
		z1 = 1;
	}
	
	MyClass(int x){
		z1 = 2;
	}
	
}

public class KonstantenUndInitBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

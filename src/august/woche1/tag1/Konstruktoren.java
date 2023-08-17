package august.woche1.tag1;

class C1 {
	
}

class C2{
	C2(int x){
		 super();
	}
}

class C3{
	int x;
	
}

class C4{
	int x = 42;
	
}

class C5{
	int x = 42;
	
	C5(){
		
	}
	
	C5(int x){
		this();
	}
	
	C5(byte b)
	{
		this.x = b;
	}	
	
	C5(short x){
		
	}
}

public class Konstruktoren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new C5((byte)107).x);
		
			new C1();
			new C2(12);

	}
	

	

}

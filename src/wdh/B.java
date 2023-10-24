package wdh;

interface P1{
	void doStuff(int x);
}

class Platon{
	void stuff(String s) {
		System.out.println("stuff");
	}
}

public class B extends Platon implements P1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new B().doStuff(1);
		new B().stuff("x");

	}
	
	@Override
	public void doStuff(int x) {
	
	}
	
	@Override
	void stuff(String s) {
		
	}

}

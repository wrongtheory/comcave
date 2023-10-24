package wdh;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int j = 7;

		assert(++j > 7);
		assert(++j > 8): "hi";
		assert(j>10):j=12;
		assert(j==12): doStuff();
		assert(j==12): new C();
		
		assert(j==1) : 1;
		
		assert false : true;
		assert true : false;
	}
	
	static void doStuff() {}

}

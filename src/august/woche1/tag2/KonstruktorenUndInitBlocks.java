package august.woche1.tag2;

/**
 * 
 */

class K1 {
	K1(){
		int x = 33;
		System.out.println("Constructor");
	}
	
	{
		String x = "moin";
		System.out.println("init block");
	}
}

class K2{
	{
		System.out.println("init 1");
	}
	
	K2(){
		System.out.println("K2");
	}
	
	K2(int x){
		this();
		System.out.println("K(int)");
	}
	
	{
		System.out.println("init 2");
	}
}
	
public class KonstruktorenUndInitBlocks {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new KonstruktorenUndInitBlocks();
		
		new K2();
		
		System.out.println("----------------------");
		
		new K2(42);

	}

}

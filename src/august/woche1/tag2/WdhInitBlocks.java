package august.woche1.tag2;

class Auto {
	
	{System.out.println("c");}
	
	static {
		System.out.println("a");
	}
}

class VW extends Auto{
	
	static {
		System.out.println("b");
	}
	
	{System.out.println("d");}
}

public class WdhInitBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VW();
	}

}

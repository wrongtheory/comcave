package august.woche1.tag2;

class Tier {
	
	{
		 System.out.println("instance Tier init 1");
	 }
	
	 static {
		System.out.println("static Tier init 1");
	}
	
	 static {
		System.out.println("static Tier init 2");
	}
	 
	 
	
}

class Hund extends Tier {
	
	{
		 System.out.println("instance Hund init 1");
	 }
	
		static {
			System.out.println("static Hund init ");
		}
	
	
}

public class KlassenLaden_StaticBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Hund();
		System.out.println("main");
		new Hund();
		
	}

}

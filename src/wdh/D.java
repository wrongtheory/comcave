package wdh;



public class D {
	
	class X extends Exception {}
	class Y extends Exception {}
	
	void drive() throws X,Y{
		throw new X();
	}
	
	public static void main(String[] args) throws X,Y{
		
		try {
			
		}catch (Exception e) {
			e = null;
			throw e;
		}

			D d = new D();
			
			try {
				d.drive();
			System.out.println("toot");
			}catch (X e) {
				// TODO: handle exception
			//System.out.println("error");
			e = new X();
			//e = new Y();
			//throw e;
			}
		}
		
	}



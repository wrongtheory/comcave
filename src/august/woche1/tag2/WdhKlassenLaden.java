package august.woche1.tag2;

class Motor{
	static {System.out.println("static init Motor");}
}

class Car {
	static {System.out.println("static init Car");}
	Motor m = new Motor();
	
	Car(){System.out.println("Car Construttor");}
}

public class WdhKlassenLaden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Car();
	}

}

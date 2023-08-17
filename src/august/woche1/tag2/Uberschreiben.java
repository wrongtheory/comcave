package august.woche1.tag2;

class Obst {
	int gewicht () {return 33;}
	Obst get() {return this;}
}

class Apfel extends Obst {
	private int gewicht(int k) {return 42;} // overloaded
	//Object get() {return this;}
}

class Birne extends Obst {
	  int gewicht() {return -1;}
	  Birne get() {return this;}
}

class Mango extends Obst{
	protected int gewicht() {return 1;}
}

class Orange extends Obst {
	//Number gewicht() {return -1;}
}

public class Uberschreiben {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

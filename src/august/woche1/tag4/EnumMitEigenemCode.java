package august.woche1.tag4;

enum ABC {
	A, // mit dem no-arg-Konstruktor
	B(77), // mit dem ABC(int)-Konstruktor
	C(); // klammer sind optional fur den no-args Konstruktor
	
	// Konstruktoren einer Enum Klass mussen iplizit/explizit private sein

	// public ABC(int x) {} // cf: muss private sein
	
	ABC(){} 				// implizit private
	private ABC(int i) { 	// explizit private
		this.index = i;
	}
	// wie in einer normalen Klasse
	
	private static ABC[] reverseValues = {C,B,A};
	
	protected static ABC[] reverseValues() {
		return reverseValues;
	}
	
	private int index;
	
	public int getIndex() {
		return index;
	}
}

public class EnumMitEigenemCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(ABC x : ABC.values()) {
			System.out.println(x + " index = " + x.getIndex());
		}
	}

}

package august.woche1.tag4;

enum Element {
	WASSER,
	ERDE,
	LUFT{
		//int att;
		//void m() {}
		
		//die toString der Klasse Element wird hier speziell fur 
		//die Konstante LUFT nochmal uberschrieben
		public String toString() {
			return "Extra-Losung fur " + super.toString();
		}
	},
	FEUER;
	
	// Uberschreiben der toString fur alle Konstanten der Klasse Element
	
		public String toString() {
			return name().toLowerCase();
		}
}

public class EnumUndUberschreiben {

	public static void main(String[] args) {
		
		for(Element e : Element.values())
			System.out.println(e);
		
		
	}

}

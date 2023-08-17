package august.woche1.tag2;

class Dozent {
	static int maxKurse = 33;
}

public class KlassenLaden_KlassenObjekte {

	public static void main(String[] arg) {
		
	int x = Dozent.maxKurse;
	
	Class<?> c1 = Dozent.class; // 1 Variante um einen KlassenObject zu finden
	
	Dozent d1 = new Dozent(); // 2 Variante um einen KlassenObject zu finden
	Class<?> c2 = d1.getClass();
	
	String className = "august.woche1.tag2.Dozent";
	
	Class<?> c3 = null;
	
	try {
		c3= Class.forName(className);
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	System.out.println(c1);
	System.out.println(c2);
	System.out.println(c3);

	}
}

	


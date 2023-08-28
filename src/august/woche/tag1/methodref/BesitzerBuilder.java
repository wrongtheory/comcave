package august.woche.tag1.methodref;

public class BesitzerBuilder {
	
	public Besitzer2 build(Auto2 auto, Integer id) {
		return Besitzer2.createInstance(auto, id);
	}

}

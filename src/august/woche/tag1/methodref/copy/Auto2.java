package august.woche.tag1.methodref.copy;

public class Auto2 {

	@Override
	public String toString() {
		return "Auto " + hashCode() + "";
	}
	
	public Besitzer2 createBesitzer(Integer id) {
		return new Besitzer2(this, id);
	}

}

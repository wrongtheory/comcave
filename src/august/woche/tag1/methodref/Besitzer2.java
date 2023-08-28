package august.woche.tag1.methodref;



public class Besitzer2 {
	
	private Auto2 auto;
	private Integer id;
	
	public static Besitzer2 createInstance(Auto2 a, Integer id) {
		return new Besitzer2(a, id);
	}
	
	
	public Besitzer2(Auto2 auto, Integer id) {
		this.auto = auto;
		this.id = id;
	}


	@Override
	public String toString() {
		return "Besistzer [auto=" + auto + ", id=" + id + "]";
	}
	
	

}

package august.woche5.tag1;

public class Fahrzeug {
	
	private String model;
	private String hersteller;
	
	public Fahrzeug(String model, String hersteller) {
		this.model = model;
		this.hersteller = hersteller;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	@Override
	public String toString() {
		return "Fahrzeug [model=" + model + ", hersteller=" + hersteller + "]";
	}
	
	

}

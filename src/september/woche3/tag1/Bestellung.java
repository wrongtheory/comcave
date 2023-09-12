package september.woche3.tag1;

public class Bestellung {
	
	private String productName;
	private int anzahl;
	
	
	public Bestellung(String productName, int anzahl) {
		this.productName = productName;
		this.anzahl = anzahl;
	}


	public String getProductName() {
		return productName;
	}


	public int getAnzahl() {
		return anzahl;
	}
	
	

}

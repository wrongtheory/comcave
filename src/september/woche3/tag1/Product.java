package september.woche3.tag1;

public class Product {

	private String name;
	private int preis;
	
	public Product(String name, int preis) {
		this.name = name;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return preis;
	}

	@Override
	public String toString() {
		return "name=" + name + ": preis=" + preis;
	}
	
	
	
	
}

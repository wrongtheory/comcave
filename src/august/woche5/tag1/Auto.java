package august.woche5.tag1;

import java.util.Objects;

public abstract class Auto {

	protected int baujahr;
	protected String modell;

	public Auto(String modell, int baujahr) {
		this.modell = modell;
		this.baujahr = baujahr;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public String getModell() {
		return modell;
	}

	public void setBaujahr(Integer baujahr) {
		this.baujahr = baujahr;
	}

	
	
	
}

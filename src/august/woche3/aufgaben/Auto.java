package august.woche3.aufgaben;

import java.util.Objects;

public class Auto {
	
	private static Besitzer besitzer;
	
	public Auto() {
		//this.besitzer = new Besitzer(getMarke(), getFabrikyahr(), this);
	}
	
	private String marke;
	private String farbe;
	private int fabrikyahr;

	public Auto(String marke, String farbe,  int fabrikyahr) {
		this.marke = marke;
		this.farbe = farbe;
		this.fabrikyahr = fabrikyahr;
	}
	
	public void setBesitzer(Besitzer b) {
		this.besitzer = b;
	}
	
	public Besitzer getBesitzer() {
		return besitzer;
	}
	
	public String getMarke() {
		return marke;
	}


	public void setMarke(String marke) {
		this.marke = marke;
	}


	public String getFarbe() {
		return farbe;
	}


	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}


	public int getFabrikyahr() {
		return fabrikyahr;
	}


	public void setFabrikyahr(int fabrikyahr) {
		this.fabrikyahr = fabrikyahr;
	}

	@Override
	public String toString() {
		return "Auto [marke=" + marke + ", farbe=" + farbe + ", fabrikyahr=" + fabrikyahr + "]";
	}
	
	public static  Besitzer findBesitzer(Auto auto, int i) {
		//System.out.println(Main.besitzers[1]);
		//System.out.println(Main.auto[1]);
		return auto.getBesitzer();
//		if(Main.besitzers[i].getAuto().equals(auto))
//		return Main.besitzers[i];
//		
//		return null;
	}
	
	public static Besitzer kaufAuto(Auto auto, Integer i) {
		auto.setBesitzer(Main.besitzers[i]);
		Main.besitzers[i].setAuto(auto);
		return besitzer;
		}

	@Override
	public int hashCode() {
		return Objects.hash(fabrikyahr, farbe, marke);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return fabrikyahr == other.fabrikyahr && Objects.equals(farbe, other.farbe)
				&& Objects.equals(marke, other.marke);
	}

	
}

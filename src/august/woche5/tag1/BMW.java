package august.woche5.tag1;

import java.util.Objects;

public class BMW extends Auto implements Comparable<BMW>{

	public BMW(String modell, int baujahr) {
		super(modell, baujahr);
	}

	
	public void setBauJahr(int baujahr) {
		this.baujahr = baujahr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baujahr, modell);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BMW other = (BMW) obj;
		return baujahr == other.baujahr && Objects.equals(modell, other.modell);
	}


	@Override
	public int compareTo(BMW o) {
		
		int i = modell.compareTo(o.modell);
		if(i == 0)
			i =  Integer.compare(baujahr, o.baujahr);
		return i;
				
	}

	
	public String toString() {
		return "BMW. Modell: " + getModell() + ", Baujahr: " + getBaujahr();
	}
	
}

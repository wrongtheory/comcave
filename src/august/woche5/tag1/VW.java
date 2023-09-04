package august.woche5.tag1;
import java.util.Objects;

public class VW extends Auto implements Comparable<VW>{

	public VW(String modell, int baujahr) {
		super(modell, baujahr);
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
		VW other = (VW) obj;
		return baujahr == other.baujahr && Objects.equals(modell, other.modell);
	}
	
	@Override
	public int compareTo(VW o) {
		
		int i = modell.compareTo(o.modell);
		if(i == 0)
			i = Integer.compare(baujahr, o.baujahr);
		return i;		
	}

	
	@Override
	public String toString() {
		return "VW. Modell: " + super.getModell() + ", Baujahr: " + super.getBaujahr();
	}

}

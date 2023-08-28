package august.woche4.tag3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Blume {
	private int preis;

	public Blume(int preis) {
		super();
		this.preis = preis;
	}
	
	public String toString() {
		return "Blume (" + preis + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(preis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blume other = (Blume) obj;
		return preis == other.preis;
	}
	
 
}

public class HashSetMitBlumen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Blume> set = new HashSet<>();
		
		set.add(new Blume(90));
		set.add(new Blume(90));
		set.add(new Blume(90));
		
		System.out.println("1. size: " + set.size());
		
		set.add(new Blume(120));
		set.add(new Blume(120));
		
		

	}

}

package august.woche4.tag3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Tier {
	
	private String name;
	private int alter;
	
	

	public Tier(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}

	
	public String toString() {
		return name + " " + alter;
	}
	
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != getClass())
			return false;
		Tier tier = (Tier)obj;
		
		return tier.alter == this.alter && this.name == tier.name;
	}
	
	public int hashCode() {
		//return 31 * alter + alter + name.hashCode();
		return Objects.hash(name,alter);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Tier> set = new HashSet<>();
		Tier t1 = new Tier("Tom", 3);
		Tier t2 = new Tier("Jerry", 7);
		
		set.add(t1);
		set.add(t2);
		
		System.out.println("size: " + set.size());
		System.out.println("set: " + set);
		
		set.add(t1);
		System.out.println("size: " + set.size());
		System.out.println("set: " + set);
		
		set.add(new Tier("Tom",3));
		
		System.out.println("size: " + set.size());
		System.out.println(set);
	}

}

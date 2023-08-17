package august.woche1.tag3;

import java.util.Arrays;
import java.util.Comparator;




class Blume implements Comparable<Blume>{
	private String name;
	private int preis;
	
	public Blume(String name, int preis) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.preis = preis;
	}
	
	public int getPreis() {
		return preis;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " " + preis;
	}
	
	public int compareTo(Blume b1) {
		
		/*
		 * Blume b1 = this; if(b1.preis > b2.preis) return 1; else if(b1.preis <
		 * b2.preis) return -1; else return 0;
		 */
		
		return name.compareTo(b1.name);
		
		 
	}
	
	
}

public class ComparableImplementieren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator<Blume> byWeight = 
				new Comparator<Blume>() {

			@Override
			public int compare(Blume o1, Blume o2) {
				// TODO Auto-generated method stub
				return o1.getPreis() - o2.getPreis();
			}
		};
		
		Blume[] arrBlumen = {
				new Blume("Rose",250),
				new Blume("Nelke",110),
				new Blume("Tulpe",175)
		};
		
		System.out.println("vor dem sort");
		System.out.println(Arrays.toString(arrBlumen));
		
		System.out.println("name sort");
		Arrays.sort(arrBlumen);
		//System.out.println(Arrays.toString(arrBlumen));
		
		//Comparator<Blume> c = (r1,r2) -> r1.preis - r2.id;
		
		System.out.println(Arrays.toString(arrBlumen));
		
		System.out.println("preis sort");
		Arrays.sort(arrBlumen,byWeight);
		
		System.out.println(Arrays.toString(arrBlumen));
		
	}

}

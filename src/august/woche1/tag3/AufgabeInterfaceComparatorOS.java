package august.woche1.tag3;

import java.util.Arrays;
import java.util.Comparator;

public class AufgabeInterfaceComparatorOS {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator cmp = new Comparator<OS>() {

			@Override
			public int compare(OS o1, OS o2) {
				Comparator<OS> c = Comparator.comparing(s -> s.getName());
				c = c.thenComparing(s->s.getVersion());
				return c.compare(o2, o1);
			}
			
		};

		OS[] array = {
				new OS("Linux", 3),
				new OS("Windows",95),
				new OS("MAC",9),
				new OS("Linux",1)
		};
		
		System.out.println("** nicht sortiert:");
		print(array);
		
		Arrays.sort(array);
	
		System.out.println("** sortiert aufsteigend:");
		print(array);
		
		int os = Arrays.binarySearch(array, new OS("Linux",1));
		System.out.println("Position: " + os);
		
		Arrays.sort(array,cmp);
		
		System.out.println("** sortiert absteigend:");
		print(array);
		
		int os2 = Arrays.binarySearch(array, new OS("Windows",95), cmp);
		System.out.println("Position :" + os2);
		
		System.out.println("\n Array mischen: ");
		Arrays.sort(array, new OSRandomComparator());
		print(array);
		
		
	}
	
	static void print(OS[] array) {
		for(int i=0; i<array.length;i++) {
			OS os = array[i];
			System.out.format("| %s | %8s | %3s| %n", i+1, os.getName(), os.getVersion());
		}
	}

}

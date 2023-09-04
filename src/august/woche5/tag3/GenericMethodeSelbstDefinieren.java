package august.woche5.tag3;

import java.time.LocalDate;

public class GenericMethodeSelbstDefinieren {

	public static void main(String[] args) {
		
		int x1 = getMax(12, -3);
		System.out.println("x1 = " + x1);
	
		int x2 = getMax(-3, 12);
		System.out.println("x2 = " + x2);
		
		double x3 = getMax(5.7, -4.2);
		System.out.println("x3 = " + x3);
		
		String x4 = getMax("ff","bb");
		System.out.println("x4 = " + x4);
		
		LocalDate x5 = getMax(LocalDate.now(), LocalDate.now().minusDays(20));
		System.out.println("x5 = " + x5);
		
		//getMax("hallo",22);
		
		
	}
	
	static <T extends Comparable<? super T>> T getMax(T a, T b) {

		if(a.compareTo(b) > 0)
			return a;
		return b;

	}

}

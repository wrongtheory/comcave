package august.woche2.tag1;

import java.text.NumberFormat;
import java.time.LocalDate;

public class DesignPatternsFactoryMethod {

	public static void main(String[] args) {
		
		Integer x1 = Integer.valueOf(12);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(12));
		
		LocalDate d1 = LocalDate.now();
		
		
	}

}

package september.woche2.tag3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class KleineAufgabe {
	
	enum Day { MO, DI, MI, DO, FR}

	public static void main(String[] args) {
		
		Day[] array = {Day.MI, Day.FR, Day.MI, Day.DI};
		
		Optional<Day> max = Arrays.stream(array).max(Comparator.naturalOrder());
		System.out.println(max.get());
		
		
		
		Day max2 = Arrays.stream(array).max(Comparator.naturalOrder()).get();
		System.out.println(max2);
		

	}

}

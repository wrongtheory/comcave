package august.woche5.tag3;

import java.time.LocalDate;
import java.util.*;

public class GenericsMethoden {

	public static void main(String[] args) {
		
		//Collections.sort(null);

		// new GenericsMethoden().<String>getFirst(new ArrayList<>());
		
		List<String> listStr = Arrays.asList("mo","di");
		String x1 = getFirst(listStr);
		
		List<Integer> listInt = Arrays.asList(12,13,14);
		Integer x2 = getFirst(listInt);
		
		Collections.sort(listStr);
		Collections.sort(listInt);
		
		List<Object> listObj = Arrays.asList(new Locale("en"), new Locale("de"));
		
		// Collections.sort(listObj); //cf
		
		List<LocalDate> listDate = Arrays.asList(LocalDate.now(), LocalDate.now());
		//mySort(listDate);
	}
	
	static <T extends Comparable<T>> void mySort(List<T> list) {
		
	}
	
	static <T> T getFirst(List<T> list) {
		T s = null;
		
		if(list.size() > 0) {
			s = list.get(0);
		}
		return s;
	}
	
	

}

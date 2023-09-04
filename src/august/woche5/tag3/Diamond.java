package august.woche5.tag3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Diamond {

	public static void main(String[] args) {
	
		// var x = 12;
		
		List<Integer> listA = new ArrayList<Integer>();
		listA.add(12);
		listA.add(13);
		
		//listA.add(1.1); //cf
		
		//List<Double> listB = new ArrayList<>(listA); // cf
		//List<Double> listB1 = new ArrayList<Double>(listA); // cf
		
		List<Double> listC = new ArrayList(listA);
		//listC.add(1);
		
		System.out.println(listC);
		
		Collection<? extends Number> param = listA;
		
		// new ArrayList<Double>(listA);
		
		Map<LocalDateTime, Collection<Map.Entry<Integer, String>>> mapA;
		
		new HashMap<LocalDateTime, Collection<Map.Entry<Integer, String>>>();
		
		Map<LocalDateTime, Collection<Map.Entry<Integer, String>>> mapB;
		
		new HashMap<>();
		
		Set<Integer> setA = new HashSet<>();
		// Set<> setB = new HashSet<>(); // cf
		
		
		Set<?> setC = new HashSet<Integer>();
		
		// Set<Integer> setD = new HashSet<?>(); // cf
		
		
		

	}

}

package september.woche5.tag2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conc {

	public static void main(String[] args) {
		
		TestUtils.testRaceCondition(new ArrayList<>());
		
		List<Integer> list = new ArrayList<>();
		
		list.add(12);
		list.add(13);
		list.add(14);
		
//		for (Integer integer : list) {
//			list.remove((Integer)13);
//			System.out.println(integer);
//			
//		}

	}

}

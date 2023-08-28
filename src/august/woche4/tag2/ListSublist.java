package august.woche4.tag2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSublist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		
		list.add(20);
		list.add(10);
		list.add(-3);
		list.add(55);
		list.add(111);
		
		
		System.out.println(list);
		
		int fromIndex = 1, toIndex = 4;
		
		List<Integer> sublist = list.subList(fromIndex, toIndex);
		System.out.println(sublist);
		
		
		sublist.add(1000);
		
		//sublist.set(1, 2023);
		System.out.println(list);
		System.out.println(sublist);
		
//		Integer arr[] = new Integer[list.size()];
//		for(int i=0 ;i<list.size();i++)
//			arr[i] = list.get(i);
//		System.out.println(Arrays.toString(arr));
		
		

	}

}

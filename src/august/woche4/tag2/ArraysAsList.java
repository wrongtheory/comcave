package august.woche4.tag2;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listStr =  Arrays.asList(args);
		
		List<Integer> listInt = Arrays.asList(12,13,14);
		
		Integer[] array = {22,-5,12,0};
		List<Integer> list = Arrays.asList(array);
		
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		
		array[1] = 2023;
		
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		
		list.set(2, -111);
		
		System.out.println(Arrays.toString(array));
		System.out.println(list);

		//list.add(4); cf
	}

}

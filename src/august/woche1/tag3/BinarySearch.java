package august.woche1.tag3;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] array = new int[20_000_000];
		
		Integer[] array = {7,-2,33,11,5};
		
		Arrays.sort(array);
		
		int i =Arrays.binarySearch(array, 11);
				
		System.out.println(Arrays.toString(array));
		
		System.out.println(i);
		
		//for(int i=0; i< array.length; i++)
			//array[i] = i;
		
		Comparator<Integer> cmp = Comparator.reverseOrder();
		Arrays.sort(array,cmp);
		
		int j =Arrays.binarySearch(array, 11, cmp);
		
		System.out.println(Arrays.toString(array));
		System.out.println(j);
		
		
		
	}

}

package august.woche4.tag2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntFunction;

public class CollectionToArray {

	public static void main(String[] args) {
		
		Collection<Integer> coll = new ArrayList<>();
		
		coll.add(12);
		coll.add(13);
		coll.add(14);
		
		
		Object[] arr1 = coll.toArray();
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr1.getClass().getSimpleName());
		
		//Integer[] tmp = (Integer[])arr1; cf
		
		Integer[] arr2 = coll.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr2));
		
		Integer[] targetArr = new Integer[5];
		Integer[] arr3 = coll.toArray(targetArr);
		System.out.println("target " + Arrays.toString(targetArr));
		System.out.println("arr3: " + Arrays.toString(arr3));
		System.out.println("target == arr3 -> " + (targetArr == arr3));
		
		IntFunction<Integer[]> f = Integer[]::new;

		
		Integer[] arr4 = coll.toArray(f);
		
		System.out.println(Arrays.toString(arr4));
		
	}

}

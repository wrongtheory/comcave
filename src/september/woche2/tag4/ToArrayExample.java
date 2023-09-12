package september.woche2.tag4;

import java.util.Arrays;

public class ToArrayExample {

	public static void main(String[] args) {
		
		Integer[] array = {-1, 22, -3, 33, -4, 44};
		
		Object[] array2 =  Arrays.stream(array)
				.filter(x -> x >= 0)
				.toArray();
		
		System.out.println(Arrays.toString(array2));
		
		Object[] array3 =  Arrays.stream(array)
				.filter(x -> x >= 0)
				.peek(x -> System.out.println(x))
				.toArray(x -> new Integer[x]);
		
		System.out.println(Arrays.toString(array3));
	}

}

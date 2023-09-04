package august.woche5.tag4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceAllSort {

	public static void main(String[] args) {
		
		testReplaceAll();
		test_sort();

	}
	
	static void test_sort() {
		List<String> list = Arrays.asList("aaaa","bb","ccccc","d");
		//list.sort(null);
		
		Comparator<String> comp = (x, y) -> x.length() - y.length();
		
		System.out.println(list);
		
		list.sort(comp);
		
		System.out.println(list);
	}
	
	static void testReplaceAll() {
		System.out.println("replaceAll");
	
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		//UnaryOperator<Integer> uop = x -> x*2;
		
		//uop.apply(2);
		
		list.replaceAll(x -> x *2);
		
		System.out.println(list);
	}

}

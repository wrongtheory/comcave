package august.woche5.tag4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Aufgabe {
	
static List<Integer> newList(){
	return Arrays.asList(1,2,3,4,5,6,7,8);
}

	public static void main(String[] args) {
		
		List<Integer> list2 = new ArrayList<>(newList());
		
		list2.removeIf(x -> x%2!=0);
		
		System.out.println(list2);
		
		List<Integer> list3 = newList();
		
		list3.replaceAll(x -> x % 2 != 0 ? 0 : x);
		
		System.out.println("1-->" + list3.size());
		
		List<Integer> coll = Arrays.asList(1,2,3,4,5,6,7,8);
		
		coll.forEach(System.out::println);
		
		coll.forEach(x -> System.out.println(x));
		
		ArrayList<Integer> coll2 = new ArrayList<>(coll);
		
		coll2.removeIf(x -> x %  2 != 0);
		
		System.out.println(coll2);
		
		ArrayList<Integer> coll3 = new ArrayList<>(coll);
		
		coll3.replaceAll(x -> x % 2 != 0 ? 0: x);
		
		System.out.println(coll3);
		
		ArrayList<Integer> coll4 = new ArrayList<>(coll);
		
		Comparator<Integer> comp1 = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		};
		
		List<Integer> list42 = newList();
		
		list42.sort((a,b) -> Integer.compare(b, a));
		
		coll4.sort(comp1);
		
		System.out.println(coll4);
		
		Comparator<Integer> comp2 = (x,y) -> y-x;
		
		coll4.sort(comp2);
		
		System.out.println(coll4);
		
		
		//Aufgabe a = new Aufgabe();
		//Comparator<Integer> comp3 = new Aufgabe()::compare;
		
		//coll4.sort(comp3);
		
		List<Integer> list43 = newList();
		
		list43.sort(Aufgabe::compare);
		
		System.out.println(coll4);
		
		Comparator<Integer> comp4 = Aufgabe::compare;
		Comparable<Integer> comp5 = Aufgabe::cmp;
		
		
		
		coll4.sort(comp4);
		
		System.out.println("aduna: "+coll4);
		
		List<Integer> notNull = Arrays.asList(1,null,2,null,3,null);
		
		System.out.println(notNull);
		
		int sum = notNull.stream().
				filter(x -> x != null).
				collect(Collectors.summingInt(x->x));
		
		int sum22 = notNull.stream().
				filter(x -> x != null)
				.mapToInt(x->x).sum();

		
		long sum2 = notNull.stream().
				map(x -> x != null ? x : 0).
				collect(Collectors.summarizingInt(x->x)).getSum();
		
		
		int sum3 = notNull.stream().
				map(x -> x != null ? x : 0).
				collect(Collectors.summingInt(x->x));
		
		
		
		
		
		IntSummaryStatistics stats = notNull.stream().
				filter(x -> x!=null).
				collect(Collectors.summarizingInt(x->x));
		
		long s = stats.getSum();
		
		System.out.println(sum);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(s);
		
		Function<List<Integer>, Integer> f = (a) -> {
			int sm = 0;
			for(Integer i : a)
				if(i != null)
					sm +=i;
			return sm;
		};

		Integer r = f.apply(notNull);
		System.out.println(r);
		
//		int[] arr = new int[1];
//		
//		notNull.forEach(x -> {
//			if(x!=null)
//				arr[0]+=x;
//		});
//		
//		System.out.println("summe: " +arr[0]);

		AtomicInteger ss = new AtomicInteger();
		
		notNull.forEach(x -> {
			if(x!=null)
				ss.addAndGet(x);
		});
		
		System.out.println("summe: " +ss.get());

		
	} //end main
	
	public static int compare(Integer a, Integer b) {
		return Integer.compare(b, a);
	}

	private static int cmp(Integer integer1) {
		return 0;
	}



}

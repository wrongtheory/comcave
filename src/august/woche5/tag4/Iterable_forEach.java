package august.woche5.tag4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

//class MyClass extends ArrayList<Integer> {
//
//	MyClass() {
//		super();
//		add(12);
//	}
//	
//	{
//		add(12); 
//		add(13); 
//		add(14);
//	}
//	
//}

public class Iterable_forEach {
	
	public static void main(String[] args) {
		
		Iterable<Integer> it = Arrays.asList(12,13,14);
		
		//Consumer<Integer> c = (i) -> {System.out.println("hallo"+i);};
		
		//c.accept(1);
		
		
		
		Consumer<Integer> c = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t + " ");
				
			}
		};
		
		it.forEach(c);
		
		it.forEach(x -> System.out.println(x));
		
		it.forEach(System.out::println);
		

	}

}

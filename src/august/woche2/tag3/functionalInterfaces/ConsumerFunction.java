package august.woche2.tag3.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunction {

	public static void main(String[] args) {
		
		
		Consumer<Integer> c1 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("t = " + t);
			}
		};
		
		c1.accept(12);
		
		Consumer<Integer> c2 = (Integer x) -> {
			System.out.println("x = " + x);
		};
		
		c2.accept(12);

		Consumer<Integer> c3 = x -> System.out.println("x = " + x);
		
		c3.accept(12);
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		list.forEach(c3);
	}

}

package august.woche3.tag5;

import java.util.Comparator;
import java.util.concurrent.Callable;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator<Integer> cmp = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				
				return a - b;
			}
		};
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("run");
				
			}
		};
		
		Callable<Void> c = new Callable<Void>() {
			
			@Override
			public Void call() throws Exception {
				
				return null ;
			}
		};

	}

}

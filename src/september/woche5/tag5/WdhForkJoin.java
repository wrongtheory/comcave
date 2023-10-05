package september.woche5.tag5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WdhForkJoin {

	public static void main(String[] args) {
		
		//b1();
		b2();

	}
	
	static void b2() {
		
		class Bar extends RecursiveAction {
			
			char ch;
			
			public Bar(char c) {this.ch = c;}

			@Override
			protected void compute() {
				System.out.println(ch + " ");
				
			}
			
		}
		
		class Foo extends RecursiveAction {

			@Override
			protected void compute() {
				Bar left = new Bar('a');			
				Bar right = new Bar('b');
				invokeAll(left,right);
				
			}
	}
		

		
		ForkJoinPool pool = new ForkJoinPool();
		RecursiveAction action =  new Foo();
		pool.invoke(action);


	}
	
	static void b1() {
		class Foo extends RecursiveAction {

			@Override
			protected void compute() {
				System.out.println("a");
				
			}
			
		}
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(new Foo()); // invoke ist synchron
		System.out.println("b");
		
	}

}

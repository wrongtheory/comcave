package september.woche5.tag5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class MyRecursiveAction extends RecursiveAction{

	@Override
	protected void compute() {
		Thread th = Thread.currentThread();
		System.out.println("coumpute with Thread: " + th.getName());
		
		
		
	}
	
}

public class ForkJoinRecursiveAction {

	public static void main(String[] args) {
		
		ForkJoinPool pool  = new ForkJoinPool();
		
		RecursiveAction action =  new MyRecursiveAction();

		pool.invoke(action); // synchron
		
		System.out.println("main");
		
		
	}

}

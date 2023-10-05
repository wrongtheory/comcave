package september.woche5.tag5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MyRecursiveTask extends RecursiveTask<String> {

	@Override
	protected String compute() {
		Thread th = Thread.currentThread();
		System.out.println("compute in Thread: " + th.getName());
		
		return "Freitag ";
	}
	
}

public class ForkJoinRecursiveTask {

	public static void main(String[] args) {
		
		
		ForkJoinPool pool = new ForkJoinPool();
		
		RecursiveTask<String> task = new MyRecursiveTask();
		
		String result = pool.invoke(task); // synchron
		
		System.out.println("main. result = " + result);
	}

}

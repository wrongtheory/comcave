package september.woche5.tag4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRegistrieren {

	public static void main(String[] args) throws  ExecutionException, InterruptedException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task1 = () -> {
			System.out.println("task1");
		};

		service.execute(task1);
		
		System.out.println("main");
		
		Callable<String> task2 = () -> {
			System.out.println("task2");
			return "mo";
		};
		
		Future<String> future2 =  service.submit(task2);
		
		String result2 =  future2.get();
		
		System.out.println(result2);
		
		Runnable task3 = () -> {
			System.out.println("task3");
		};

		Future<?> future3 =  service.submit(task3);
		
		Object ob = future3.get();
		
		System.out.println(ob);
		
		System.out.println("main nach der task3");
		
		AtomicInteger austausch = new AtomicInteger(); 
		
		Runnable task4 = () -> {
			System.out.println("task4");
			austausch.set(42);
		};
		
		Future<AtomicInteger> future4 =  service.submit(task4, austausch);
		
		AtomicInteger result4 =  future4.get();
		
		System.out.println(result4);
		
		Collection<Callable<Integer>> tasks = Arrays.asList(
				 () -> 1,
				 () -> 2,
				 () -> 3
				);
		
		List<Future<Integer>> futures = service.invokeAll(tasks);
		
		for(Future<Integer> f : futures)
			System.out.println(f.get());
		
		Integer x = service.invokeAny(tasks);
		
		System.out.println(x);
		
		service.shutdown();
		
	}

}

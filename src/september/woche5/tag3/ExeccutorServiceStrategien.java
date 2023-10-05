package september.woche5.tag3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExeccutorServiceStrategien {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService s1 = Executors.newSingleThreadExecutor();
		//taskAusfuehren(s1);
		
		int nThreads = 2;
		
		ExecutorService s2 = Executors.newFixedThreadPool(nThreads);
		//taskAusfuehren(s2);
		
		ExecutorService s3 = Executors.newCachedThreadPool();
		taskAusfuehren(s3);



	}
	
	static void taskAusfuehren(ExecutorService service) throws InterruptedException {
		
		Set<Long> set = Collections.synchronizedSet(new HashSet<>());
		
		
		
		Runnable task = () -> {
			Thread th = Thread.currentThread();
			System.out.println("Thread-ID: " + th.getId());
			set.add(Thread.currentThread().getId());
		};
		
		for (int i = 0; i < 100; i++) {
			service.execute(task);
		}
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.DAYS);
		
		
		System.out.println(set.size());
	}
	
	

}

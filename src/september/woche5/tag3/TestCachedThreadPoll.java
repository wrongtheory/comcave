package september.woche5.tag3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCachedThreadPoll {

	public static void main(String[] args) throws InterruptedException {
		
		Set<Long> set = Collections.synchronizedSet(new HashSet<>());

		ExecutorService service = Executors.newCachedThreadPool();
		
		
		
		for(int i=0;i<1000;i++) {
			service.execute(() -> {
				Thread th = Thread.currentThread();
				System.out.println("Thread-ID: " + th.getId());
				set.add(th.getId());
			});
		}
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println(set.size() + " Threads haben die Tasks ausgefuehrt");
	}

}

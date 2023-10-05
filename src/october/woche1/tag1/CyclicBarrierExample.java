package october.woche1.tag1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int parties = 3;
		
		CyclicBarrier barrier = new CyclicBarrier(parties);

		
		Runnable target = () -> {
			Thread th = Thread.currentThread();
			System.out.println("Thread: " + th.getId() + " vor der barrier");
			
			try {
				barrier.await();
			}catch(InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("Thread " + th.getId() + " nach der Barriere");
		};
		
		new Thread(target).start();
		new Thread(target).start();
		Thread.sleep(2000);
		new Thread(target).start();
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(target);
		service.execute(target);
		service.execute(target);
		
		service.shutdown();

	}
	

}

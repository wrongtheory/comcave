package september.woche5.tag4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

	public static void main(String[] args) {
		
		
		ScheduledExecutorService service =  Executors.newSingleThreadScheduledExecutor();
		
		ScheduledExecutorService s2 =  Executors.newScheduledThreadPool(4);

		Runnable task = () -> {
			System.out.println("task");
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		};
		
		//service.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
		
		service.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);
		
		
	}
	
	static void test_Fixed_Rate() {
		
	}

}

package september.woche5.tag4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDown {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task1 = () -> {
			System.out.println("task1");
			try {
				Thread.sleep(5000);
			}catch(Exception e) {
				System.out.println("sleep interrupted");
				Thread.currentThread().interrupt();
			}
		};
		
		service.execute(task1);
		service.execute(task1);
		//service.execute(task1);
		
		System.out.println("main");
		
		List<Runnable> list = service.shutdownNow();
		//service.shutdown();
		//service.awaitTermination(51, TimeUnit.SECONDS);
		
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i));
		
		

	}
	
	static void pause(long millis) {

	}

}

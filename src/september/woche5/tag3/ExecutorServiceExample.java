package september.woche5.tag3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task = () -> System.out.println("run");
		
		service.execute(task);
		
		service.shutdown();

	}

}

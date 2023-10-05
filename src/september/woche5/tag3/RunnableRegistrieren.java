package september.woche5.tag3;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableRegistrieren {

	public static void main(String[] args) throws InterruptedException {
		
		int[] array = {-7, 22, 3, -1, 4};
		
		Runnable task1 = () -> {
		
			for(int i=0;i<array.length;i++) {
				if(array[i] < 0) {
					array[i] = 0;
				}
			}
			
		};
		
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(task1);
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.SECONDS);
		
		System.out.println("array: " + Arrays.toString(array));
	}

}

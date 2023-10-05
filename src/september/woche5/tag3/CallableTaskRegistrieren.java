package september.woche5.tag3;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTaskRegistrieren {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		aufgabeCallable();
		aufgabeCallable2();

	}
	
	static void aufgabeCallable() throws InterruptedException, ExecutionException {
		
		int[] array = {-7, 22, 3, -1, 4};
		
		Callable<Integer> task1 = () -> {
		
			int count = 0;
			
			for(Integer x : array) {
				if(x < 0) {
					count++;
				}
			}
			
			return count;
			
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<Integer> future1 = service.submit(task1);
		
		service.shutdown();
		
		Integer count = future1.get();
		
		System.out.println("count: " + count);

	}
	
	static void aufgabeCallable2() throws InterruptedException {
		int[] array = {-7, 22, 3, -1, 4};
		
		Callable<Void> task1 = () -> {
			for(int i=0;i<array.length;i++) {
				if(array[i] < 0) {
					array[i] = 0;
				}
			}
			return null;
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(task1);
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("array: " + Arrays.toString(array));
	}

}

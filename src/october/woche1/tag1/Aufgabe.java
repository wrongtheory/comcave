package october.woche1.tag1;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Aufgabe {
	
	static int count;
	
	public static void main(String[] args) {
//		bsp1();
//		bsp2();
//		bsp3();
		bsp4();
	}
	
	public static void bsp4() {
		AtomicInteger count = new AtomicInteger();

		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable barrierAction = () -> {
			System.out.println("count: " + count);
		};
		
		CyclicBarrier barrier = new CyclicBarrier(2, barrierAction);
		
		Callable<Void> task = () -> {
			for(int i=0;i<1_000_000;i++) {
					count.getAndIncrement();
			}
				
			barrier.await();
			return null;
		};
		
		service.submit(task);
		service.submit(task);
		//service.submit(task);
		
		service.shutdown();
	}


	public static void bsp3() {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable barrierAction = () -> {
			System.out.println("count: " + count);
		};
		
		CyclicBarrier barrier = new CyclicBarrier(2, barrierAction);
		
		Callable<Void> task = () -> {
			for(int i=0;i<1_000_000;i++) {
				synchronized (barrier) {
					count++;
				}
			}
				
			barrier.await();
			return null;
		};
		
		service.submit(task);
		service.submit(task);
		//service.submit(task);
		
		service.shutdown();
	}

	
	public static void bsp2() {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable barrierAction = () -> {
			System.out.println("count: " + count);
		};
		
		CyclicBarrier barrier = new CyclicBarrier(2, barrierAction);
		
		Callable<Void> task = () -> {
			for(int i=0;i<1_000_000;i++) {
				count++;
			}
				
			barrier.await();
			return null;
		};
		
		service.submit(task);
		service.submit(task);
		//service.submit(task);
		
		service.shutdown();
	}

	public static void bsp1() {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Runnable barrierAction = () -> {
			System.out.println("count: " + count);
		};
		
		CyclicBarrier barrier = new CyclicBarrier(2, barrierAction);
		
		Callable<Void> task = () -> {
			for(int i=0;i<1_000_000;i++) {
				count++;
			}
				
			barrier.await();
			return null;
		};
		
		service.submit(task);
		service.submit(task);
		//service.submit(task);
		
		service.shutdown();
	}

}

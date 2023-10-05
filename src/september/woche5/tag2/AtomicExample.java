package september.woche5.tag2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicExample {
	
	static int count;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//versuch1();
		//versuch2();
		versuch3();
	
	}
	
	public static void versuch1() throws InterruptedException {
	Runnable target = () -> {
		for (int i = 0; i < 1_000_000; i++) {
			count++;
		}
	};

	Thread t1 = new Thread(target);
	Thread t2 = new Thread(target);

	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Count: "  + count);
	}
	
	public static void versuch2() throws InterruptedException {
		
		Lock lock = new ReentrantLock();
		
	Runnable target = () -> {
		for (int i = 0; i < 1_000_000; i++) {
			lock.lock();
			count++;
			lock.unlock();
		}
	};

	Thread t1 = new Thread(target);
	Thread t2 = new Thread(target);

	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Count: "  + count);
	}
	
	public static void versuch3() throws InterruptedException {
	
		AtomicInteger atomicCount = new AtomicInteger();
		
		
		Runnable target = () -> {
		for (int i = 0; i < 20_000_000; i++) {
			atomicCount.getAndIncrement();
		}
	};

	Thread t1 = new Thread(target);
	Thread t2 = new Thread(target);

	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Count: "  + atomicCount.get());
	}



}

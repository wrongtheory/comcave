package september.woche4.tag4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class ThreadExample extends Thread {
	
	public void run() {
		//for(;;) {
//		System.out.println("Name: " + Thread.currentThread().getName());
//		System.out.println("ID: " + Thread.currentThread().getId());
		System.out.println(getName().toUpperCase() + " with id " + getId() + " was started");
		}
		//}
	}
	


class RunnableExample implements Runnable {

	@Override
	public void run() {
		for(;;) {
		System.out.println("Name: " + Thread.currentThread().getName());
		System.out.println("ID: " + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		
	}
	
}

public class ThreadsAufgabe {

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new ThreadExample();
		Runnable runnable = new RunnableExample();
		Thread thread2 = new Thread(runnable);
		
		//thread1.start();
		//thread2.start();
	
		Thread[] threads = new ThreadExample[10];
		
		List<Thread> list = new ArrayList<>();
		
		Runnable target = () -> {
			String name = Thread.currentThread().getName();
			Long id =  Thread.currentThread().getId();
			System.out.println("Thread: " + name + " ID: " + id + " was started");

		};
	
		//for(ThreadExample t : threads) {
		for(int i=0;i<10;i++) {	
			Thread t = new Thread(target);
			System.out.println("Thread " + t.getName() + " id: " + t.getId() + " was created");
			list.add(t);
			t.sleep(1000);
//			Thread t = new ThreadExample();
//			t.setName("Thread"+i);
//			threads[i] = t;
//			System.out.println(t.getName()+ " with id " + t.getId() + " was created");
//			Thread.sleep(300);
		}
		
		
		//for(Thread t : threads) {
		for(Thread t : list) {
			t.start();
		//for(int i=0;i<37;i++) {		
			//t.start();
			//System.out.println(t.getName()+ " with id " + t.getId() + " was started");
			//Thread.sleep(300);
			t.sleep(1000);

		}
		
		Runnable runn = new newThread();
		
		Thread t1 = new Thread(runn,"Tom");
		Thread t2 = new Thread(runn,"Jerry");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}
	
	public static void bigJob() {
        Thread th = Thread.currentThread();
        System.out.println("Starte " + th.getName() 
            + ". Priorität: " + th.getPriority());

        long start = System.currentTimeMillis();

        int exists = 0;
        for (int i = 0; i < 100_000_0; i++) {
            Path path = Paths.get("/"+i);
            if(Files.exists(path)) {
                exists++;
            }
        }

        long ende = System.currentTimeMillis();

        System.out.println("Thread: " + th.getName() 
                + ", Zeit: " + (ende-start)/1000. + " Sek. / " + exists);
    }


}

class newThread implements Runnable{

	@Override
	public void run() {
		ThreadsAufgabe.bigJob();
		
	}
	
}

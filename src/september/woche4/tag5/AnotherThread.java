package september.woche4.tag5;

import java.util.concurrent.atomic.AtomicInteger;

class Test extends Thread {
	
 static AtomicInteger count = new AtomicInteger();
 static AtomicInteger k = new AtomicInteger();
 static int should = 1_000_000;
    public void run() {

    	
    		Magic();
   }
   private synchronized void Magic() {
	   for(int i=0;i<1_000_000;i++) {
		   
		   if(count.get() == 1_000_000)
			   {
			   Thread.currentThread().interrupt();
			   return;
			   }
		   count.incrementAndGet();
//consider synchronizing this method, but if you do method will be accessable by one thread at a time.
    }

}
}
public class AnotherThread {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Test();
		Thread t2 = new Test();
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("count: " + Test.count);
	}

}

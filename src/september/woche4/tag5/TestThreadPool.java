package september.woche4.tag5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class WorkerThread implements Runnable {
static AtomicInteger count = new AtomicInteger();
    public void run() {

       Magic();
   }
   private synchronized void Magic() {
	   count.incrementAndGet();
//consider synchronizing this method, but if you do method will be accessable by one thread at a time.
    }

}

public class TestThreadPool {
    public static void main(String[] args) {
       ExecutorService executor = Executors.newFixedThreadPool(100);

       for (int i = 0; i < 1_000_000; i++) {
           Runnable worker = new WorkerThread();
           executor.execute(worker);
         }
       executor.shutdown();
      while (!executor.isTerminated()) {}
      
      System.out.println(WorkerThread.count);
	}
           
}

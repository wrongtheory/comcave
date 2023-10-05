package october.woche1.tag1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RaceCar implements Runnable {
    private String name;
    private static List<RaceCar> finish;
    
    CyclicBarrier barrier;

    public RaceCar(String name, List<RaceCar> finish, CyclicBarrier barrier) {
        this.name = name;
        RaceCar.finish = finish;
        this.barrier = barrier;
    }

    public void run() {
        
        //System.out.println(name + " vor der barriere");
		try {
			//System.out.println(barrier.getParties());
			//System.out.println(barrier.getNumberWaiting());
			System.out.println(name + " started.");
			barrier.await();
			
			//System.out.println("barrier broken? : " + barrier.isBroken());
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        finish.add(this);
        System.out.println(name + " finished.");
        //System.out.println("barrier broken? : " + barrier.isBroken());
        
    }
    public String toString() {
        return name;
    }
    
    public static List<RaceCar> finishList(){
    	return finish;
    }
}

public class Main {
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		List<RaceCar> list = Collections.synchronizedList(new ArrayList<>());
		
		CyclicBarrier barrier = new CyclicBarrier(4);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new RaceCar("Car1", list, barrier));
		Thread.sleep(1000);
		service.execute(new RaceCar("Car2", list, barrier));
		Thread.sleep(1000);
		service.execute(new RaceCar("Car3", list, barrier));
		Thread.sleep(1000);
		service.execute(new RaceCar("Car4", list, barrier));
		
		service.awaitTermination(3, TimeUnit.SECONDS);
		
		service.shutdown();
		
		System.out.println("Final Finish List: " + RaceCar.finishList());
		
	}
	
}

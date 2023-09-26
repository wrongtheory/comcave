package september.woche5.tag1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
	private int number;
	Chopstick leftChopstick;
	Chopstick rightChopstick;
	
	public Philosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
		this.number = number;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}
	
	void performAction(String action) throws InterruptedException {
		try {
			int waitTime = ThreadLocalRandom.current().nextInt(0,1000);
			System.out.println("Philosopher " + (number + 1) + action + waitTime + " ms");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			try {
				performAction(" thinks for ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			leftChopstick.grapChopstick();
			System.out.println("Philosopher " + (number+1) + " picks up leftChopstick");
			rightChopstick.grapChopstick();
			System.out.println("Philosopher " + (number +1) + " picks up rightChopstick");
			try {
				performAction(" eats for ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			leftChopstick.dropChopstick();
			System.out.println("Philosopher " + (number+1) + " drops leftChopstick");
			rightChopstick.dropChopstick();
			System.out.println("Philosopher " + (number +1) + " srops rightChopstick");
		}
		
	}
	
	public static void main(String[] args) {
		
		Philosopher[] philosophers = new Philosopher[5];
		
		int no_of_philosophers  = DinningPhilosophers.no_of_philosophers;
		Chopstick[] chopstick = new Chopstick[no_of_philosophers];
		for(int i=0;i<no_of_philosophers;i++) {
			chopstick[i] = new Chopstick();
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(no_of_philosophers);
		
		for(int i = 0; i < no_of_philosophers;i++) {
			if(i%2==0)
			philosophers[i] = new Philosopher(i, chopstick[i], chopstick[(i+1) % no_of_philosophers]);
			else
				philosophers[i] = new Philosopher(i, chopstick[(i+1) % no_of_philosophers], chopstick[i]);
			executor.execute(philosophers[i]);
		}
	}
	
	}

	


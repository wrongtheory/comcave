package september.woche5.tag1;

import java.util.concurrent.Semaphore;

public class Chopstick {
	
	public Semaphore semaphore = new Semaphore(1);
	
	void grapChopstick() {
		try {
			semaphore.acquire();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void dropChopstick() {
		semaphore.release();
	}

}

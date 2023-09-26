package september.woche4.tag5;

class ThreadInterr extends Thread {
	public void run() {
		while(!interrupted()) {
			System.out.println(isInterrupted());
			System.out.println("Thread " + getId() + " runs");
			
			try {
				Thread.sleep(10 * 60 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Thread " + getId() + " is interrupted " + isInterrupted());
				break;
				//e.printStackTrace();
			}
		}
		System.out.println("Thread " + getId() + " is dead");
	}
}

public class ThreadInterrupted {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new ThreadInterr();
		
		t1.start();
		
		Thread.sleep(5000);
		
		System.out.println("main-Thread interrupted den Thread" + t1.getId());
		
		t1.interrupt();
		System.out.println("is interrupted: " + t1.isInterrupted());
		
	}

}

package september.woche4.tag5;

class EndThread extends Thread {
	
	private volatile boolean beenden;
	
	public void beenden() {
		this.beenden = true;
	}
	
	public void run() {
		while(!beenden) {
			System.out.println("ID: " + getId() + " runs");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + getId() + " ist dead");
	}
}

public class ThreadComunication {

	public static void main(String[] args) throws InterruptedException {

		EndThread t1 = new EndThread();
		t1.start();
		
		Thread.sleep(7000);
		
		System.out.println("main try the thread " + t1.getId() + " to stop");
		
		
		t1.beenden();
		
	}

}

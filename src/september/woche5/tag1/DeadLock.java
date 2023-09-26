package september.woche5.tag1;

class ThreadMitDeadlock extends Thread {
	
	private static Object m1 = new Object();
	private static Object m2 = new Object();
	
	@Override
	public void run() {
		synchronized (m1) {
			System.out.println("m1");
			
			synchronized (m2) {				
				System.out.println("m1.m2");
			}
		}
		
		synchronized (m2) {
			System.out.println("m2");
			
			synchronized (m1) {
				System.out.println("m2.m1");
			}
		}
	}
}

public class DeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ThreadMitDeadlock().start();
		new ThreadMitDeadlock().start();
		
	}

}

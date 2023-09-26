package september.woche5.tag1;

public class Synchronisieren {
	
	static int count;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int loops = 1_000_000;
		
		Object monitor = new Object();
		
		Runnable target1 = () -> {
			for (int i = 0; i < loops; i++) {
				synchronized (monitor){
					count++;
				}
			}
		};
		
		Runnable target2 = () -> {
			for (int i = 0; i < loops; i++) {
				
				synchronized(monitor){
					count--;
				}
			}
		};
	
		Thread t1 = new Thread(target1);
		Thread t2 = new Thread(target2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("count: " + count);
	}

}

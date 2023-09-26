package september.woche5.tag1;

class B1 {
	
	private static int count;
	
	static void doStuff() throws InterruptedException {
		Runnable target = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (B1.class) {
					count++;
				}
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("count: " + count);
	}
}



public class Monitor {

	public static void main(String[] args) throws InterruptedException {
		
		B1.doStuff();

	}

}

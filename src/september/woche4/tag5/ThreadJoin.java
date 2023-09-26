package september.woche4.tag5;

public class ThreadJoin {
	
	static int count;

	public static void main(String[] args) throws InterruptedException {
		
		
		Runnable target = () -> {
			
				for(int i=0;i<1_000_000;i++) {
					
					count++;
				
				
			}
		};
		
		Thread t1 = new Thread(target);
		t1.start();
		
		
		t1.join((long)1.0000001);
		//t1.join();
		
		System.out.println("count: " + count);

	}

}

package september.woche4.tag4;

public class ThreadSimpleAPI {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		Thread t1 =  new Thread();
		
		System.out.println(t1.getName());
		
		t1.setName("Jora");
		System.out.println(t1.getName());
		System.out.println(t1.getId());
		
		Thread.yield();
		
		Thread t3 =  Thread.currentThread();
		System.out.println(t3);
		
		Thread.sleep(1000);
	}

}

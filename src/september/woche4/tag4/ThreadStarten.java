package september.woche4.tag4;

public class ThreadStarten {

	public static void main(String[] args) throws InterruptedException {
		
		Thread1 th =  new Thread1(); // new
		
		th.start(); // runnable
		
		Thread.sleep((long)0.9);
		
		System.out.println("main");
		
		
	}

}

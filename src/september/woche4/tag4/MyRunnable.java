package september.woche4.tag4;

class RunableInterface1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Run");
		
	}
	
}

public class MyRunnable {

	public static void main(String[] args) {

		Runnable target = new RunableInterface1();
		Thread t = new Thread(target);
		
		t.start();
		
		for(int i=0;i<1_000_000;i++) {	
		}
		
		System.out.println("Main");
		
	}

}

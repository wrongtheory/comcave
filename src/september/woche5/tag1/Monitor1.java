package september.woche5.tag1;

import java.util.Iterator;

class B2 implements Runnable{
	private int count;

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; i++) {
			synchronized (this) {
				count++;
			}
		}
		
	}
	
	public int getCount() {
		return count;
	}
}

public class Monitor1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		B2 targetA = new B2();
		B2 targetB = new B2();
		
		
		Thread tX = new Thread(targetA);
		Thread tY = new Thread(targetA);
		
		Thread tZ = new Thread(targetB);
		
		tX.start();
		tY.start();
		tZ.start();
		
		tX.join();
		tY.join();
		
		
		System.out.println("targetA.getCount: " + targetA.getCount());
		tZ.join();
		System.out.println("targetB.getCount: " + targetB.getCount());
	}

}

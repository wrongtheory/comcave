package september.woche5.tag1;

import java.util.List;

class Philosoph extends Thread {
	
	private static Object gabel1 = new Object();
	private static Object gabel2 = new Object();
	//private static Object gabel3 = new Object();

	static int i = 0;
	
	public void run() {
		while(true) {
			//System.out.println("Runde: " + i++);
		synchronized (gabel1) {
			System.out.println("Philosoph " + getName() + " takes the links gabel1");
			synchronized (gabel2) {
				
				System.out.println("Philosoph " + getName() + " takes the rechts gabel2");
				System.out.println("Philosoph " + getName() + " isst");
			}
			System.out.println("Philosoph " + getName() + " legt the rechts gabel2 ab");
		}
		System.out.println("Philosoph " + getName() + " legt the links gabel1 ab");
		
		
		synchronized (gabel2) {
			System.out.println("Philosoph " + getName() + " takes the links gabel2");
			synchronized (gabel1) {
				
				System.out.println("Philosoph " + getName() + " takes the rechts gabel1");
				System.out.println("Philosoph " + getName() + " isst");
			}
			System.out.println("Philosoph " + getName() + " legt the rechts gabel1 ab");
		}
		System.out.println("Philosoph " + getName() + " legt the links gabel2 ab");

		
//		synchronized (gabel2) {
//			
//			System.out.println("Philosoph " + getName() + " takes the links gabel2");
//			
//			synchronized (gabel3) {
//				System.out.println("Philosoph " + getName() + " takes the recths gabel3");
//				System.out.println("Philosoph " + getName() + " isst");
//			}
//			System.out.println("Philosoph " + getName() + " legt the rechts gabel3 ab");
//		}
//		System.out.println("Philosoph " + getName() + " legt the links gabel2 ab");
//		
//		synchronized (gabel3) {
//			
//			System.out.println("Philosoph " + getName() + " takes the links gabel3");
//			
//			synchronized (gabel1) {
//				System.out.println("Philosoph " + getName() + " takes the rechts gabel1");
//				System.out.println("Philosoph " + getName() + " isst");
//			}
//			System.out.println("Philosoph " + getName() + " legt the rechts gabel1 ab");
//		}
//		System.out.println("Philosoph " + getName() + " legt the links gabel3 ab");
		}
		
	}
}

public class PhilosophenProblem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Philosoph p1 = new Philosoph();
		Philosoph p2 = new Philosoph();
		Philosoph p3 = new Philosoph();
		p1.setName("P1");
		p2.setName("P2");
		p3.setName("P3");
		
		p1.start();
		p2.start();
		p3.start();
		
		p1.join();
		p2.join();
		p3.join();
		
	}

}

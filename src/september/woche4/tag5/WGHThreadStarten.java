package september.woche4.tag5;

public class WGHThreadStarten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//b1();
		//b2();
		//b3();
		b6();

	}
	
	static void b6() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("b");
			}
		};
		//t1.start();
		t1.start();
		t1.start();
		
		System.out.println("a");
	}

	
	static void b5() {
		
		Runnable target = () -> System.out.println("a ");
		
		Thread th = new Thread(target) {
			public void run() {
				System.out.println("b ");
			}
		};
		
		th.start();
	}
	
	static void b3() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("b");
			}
		};
		//t1.start();
		t1.start();
		
		System.out.println("a");
	}

	
	static void b2() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("b");
			}
		};
		//t1.start();
		t1.run();
		
		System.out.println("a");
	}

	
	static void b1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("b");
			}
		};
		//t1.start();
		
		System.out.println("a");
	}

}

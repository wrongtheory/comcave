package september.woche5.tag1;

public class Philosopher1 implements Runnable{
	
	private Object leftFork;
	private Object rightFork;

	
	
	public Philosopher1(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}
	
	private void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((int)Math.random()*100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Philosopher1[] philosophers = new Philosopher1[3];
		Object[] forks = new Object[philosophers.length];
		
		for(int i = 0; i<forks.length; i++) {
			forks[i] = new Object();
		}
		
		for(int i =0; i < philosophers.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];
			
			if( i == philosophers.length-1)
			
			philosophers[i] = new Philosopher1(rightFork, leftFork);
			else
				philosophers[i] = new Philosopher1(leftFork, rightFork);
			
			Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(true) {
				//thinking
				doAction(System.nanoTime() + ": Thinking");
				synchronized (leftFork) {
					doAction(System.nanoTime() + ": Picked up left fork ");
					synchronized (rightFork) {
					//eating	
						doAction(System.nanoTime() + ": Picked up right fork - eating");
						doAction(System.nanoTime() + ": Put down right fork");
					}
					//back to thinking
					doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
				}
			}
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
	}

}

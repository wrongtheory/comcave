package september.woche5.tag2;

import java.util.concurrent.locks.Lock;

public class Philosoph extends Thread {

	
	public Philosoph(String name) {
		super(name);
	}
	
	private Lock leftLock;
	private Lock rightLock;
	
	public void setLeftLock(Lock leftLock) {
		this.leftLock = leftLock;
	}
	
	public void setRightLock(Lock rightLock) {
		this.rightLock = rightLock;
	}
	
//	private Object linkeGabel;
//	private Object rechteGabel;
//	
//	public void setLinkeGabel(Object linkeGabel) {
//		this.linkeGabel = linkeGabel;
//	}
//	
//	public void setRechteGabel(Object rechteGabel) {
//		this.rechteGabel = rechteGabel;
//	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println(getName() + " denkt nach...");
			System.out.println(getName()  + " hat hunger");
			if(leftLock.tryLock()) {
				System.out.println(getName()  + " nimmt die linke Gabel");
				if(rightLock.tryLock()) {
					System.out.println(getName()  + " nimmt die rechte Gabel");
					System.out.println(getName()  + " isst");
					System.out.println(getName()  + " legt die rechte Gabel ab");
					rightLock.unlock();
					System.out.println(getName() + " legt die linke Gabel ab");
				}
			leftLock.unlock();
			}
		}
	}

}

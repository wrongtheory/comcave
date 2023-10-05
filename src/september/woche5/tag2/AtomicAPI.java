package september.woche5.tag2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AtomicInteger x1 = new AtomicInteger();
		
		x1.set(44);
		
		int val = x1.get();
		
		int delta = 3;
		
		x1.addAndGet(delta);
		
		System.out.println(x1);

		int res = x1.getAndAdd(3);
		System.out.println(res);
		System.out.println(x1);
		
		
	}

}

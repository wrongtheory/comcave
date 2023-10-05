package september.woche5.tag2;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {

	public static void main(String[] args) {
		
		ThreadLocalRandom rnd = ThreadLocalRandom.current();
		
		int value = rnd.nextInt(100);
		
		

	}

}

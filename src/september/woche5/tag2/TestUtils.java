package september.woche5.tag2;

import java.util.Collection;

public class TestUtils {

	static void testRaceCondition(Collection<Integer> coll){
		
		System.out.println("*** test " + coll.getClass());
		
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				coll.add(i);
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("size: " + coll.size());
		
	}


}

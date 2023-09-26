package september.woche5.tag1;

import java.util.ArrayList;
import java.util.List;

public class Frage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		
		Integer mon = 0;
		
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				synchronized (mon) {
					list.add(1);
				}
				
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
		t1.join();//
		t2.join();
		
		System.out.println(list.size());

	}

}

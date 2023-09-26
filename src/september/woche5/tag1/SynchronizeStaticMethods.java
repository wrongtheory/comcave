package september.woche5.tag1;

class StaticValue{
	private static int value;
	
//	public static void increment() {
//		
//			synchronized (StaticValue.class) {
//				value++;
//			}
//		}
	
	public synchronized static void increment() {
		value++;
	}
	
	public static int getValue() {
		return value;
	}
}


public class SynchronizeStaticMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Runnable target = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				StaticValue.increment();
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);

		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(StaticValue.getValue());
	}

}

package september.woche5.tag1;

class MyValue{
	private int value;
	
	synchronized public void  increment() {
		value++;
	}
	
	public int getValue() {
		return value;
	}
}

public class InstanszMethodenSynchronisieren {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println(29%30);
		
		MyValue value = new MyValue();
		
		Runnable target = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				value.increment();
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Value: " + value.getValue());
	}

}

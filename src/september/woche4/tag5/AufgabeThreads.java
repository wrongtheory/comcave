package september.woche4.tag5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ThreadA implements Runnable{

	static List<Integer> list = new ArrayList<>();
	
	private int val;
	
	public ThreadA(int val) {
		this.val = val;
	}
	
	@Override
	public void run() {
//		System.out.println("***Thread A");
//		
//		list = Stream.generate(Random::new)
//			.limit(val)
//			.map(x -> x.nextInt(10))
//			.collect(Collectors.toList());
		
		for (int i = 0; i < val; i++) {
			list.add(new Random().nextInt(10));
		}
		
	getList();
			
		System.out.println(list);
	}
	
	static List<Integer> getList(){
		//System.out.println(list);
		return list;
	}
	
}

//class ThreadB implements Runnable{
//
//	static List<Integer> list = new ArrayList<>();
//	
//	@Override
//	public void run() {
//		System.out.println("***Thread B");
//		
//		list = Stream.generate(Random::new)
//			.limit(30)
//			.map(x -> x.nextInt(10))
//			.collect(Collectors.toList());
//		
//	getList();
//			
//		//System.out.println(list);
//	}
//	
//	static List<Integer> getList(){
//		return list;
//	}
//	
//}

class ThreadCount extends Thread {
	static int count;
	public void run() {
		Stream.iterate(0, x -> x + 1).limit(1_000_000).forEach(c -> {
			count++;
		});
}
}

class ThreadLast extends Thread {
	static int i;
	public void run() {
		//System.out.println("ThreadLast runs...");
		System.out.println("Thread " + getName() + " runs");
		while(!interrupted()) {
			
			
			try {
				System.out.println(i);
				i++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread " + getName()+ " is interrupted ");
				break;
			}
		}
	}
}

public class AufgabeThreads {

	public static void main(String[] args) throws InterruptedException {
		ThreadA runn = new ThreadA(20);
		ThreadA runn2 = new ThreadA(30);

		Thread t1 = new Thread(runn);
		Thread t2 = new Thread(runn2);
		Thread t3 = new ThreadCount();
		Thread t4 = new ThreadLast();
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		int summe = Stream.of(runn.getList(), runn2.getList())
			.flatMap(List::stream)
			.reduce(0, (a,b) -> a + b);
		
		System.out.println("List A: " + runn.getList() + " size: " + runn.getList().size());
		System.out.println("List B : " + runn2.getList() + " size: " + runn2.getList().size());
//		ThreadA.list.addAll(ThreadB.list);
//		System.out.println("List C(A+B): " + ThreadA.list + " size: " + ThreadA.list.size());
		
		long sum = ThreadA.list.stream().collect(Collectors.summarizingInt(x ->x)).getSum();
		int s = ThreadA.list.stream().reduce((a,b) -> a +b).get();
		int b =  ThreadA.list.stream().collect(Collectors.summingInt(x -> x));
		System.out.println("Sum (A+B) is: " + sum);
		System.out.println(s);
		System.out.println(b);
		System.out.println("summe: " + summe);
		
		System.out.println("Count: " + ThreadCount.count);
		
		
		
		//t4.join();
		
		Thread.sleep(5000);
		
		System.out.println("Thread Main interrupst thread " + t4.getName());
		t4.interrupt();
		//System.out.println("Thread " + t4.getName() + " is interupted");
		System.out.println("main");
	}
}

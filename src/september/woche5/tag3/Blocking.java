package september.woche5.tag3;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Blocking {

	public static void main(String[] args) throws InterruptedException {
		
		//test_Konstruktoren();
		//test_einfacheMethoden();
		test_blokierendeMethoden();
	}
	
	static void test_blokierendeMethoden() throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		
		queue.add(12);
		queue.offer(13);
		queue.put(14);
		queue.put(15);

	}
	
	static void test_einfacheMethoden() {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		
		queue.add(12);
		queue.add(13);
		queue.add(14);
		
		
		try {
			queue.add(15);
		}catch (IllegalStateException e) {
			e.getMessage();
			System.out.println("Queue is voll");
		}
		
		System.out.println("queue: " + queue);
		
		System.out.println("next: " + queue.element());
		
		System.out.println("removed: " + queue.remove());
		
		System.out.println("queueL " + queue);
		
		queue.clear();
		
		System.out.println("queueL " + queue);
		
		try {
			queue.element();
		}catch(NoSuchElementException e) {
			System.out.println("No elements");
		}
		
	}
	
	static void test_Konstruktoren() {
		
		int capacity = 3; // Maximal capacity
		
		BlockingQueue<Integer> q1 = new ArrayBlockingQueue<>(capacity);
		
		q1.add(1);
		q1.add(2);
		q1.add(3);
		//q1.add(4); exception, Queue is full
		
		BlockingQueue<Integer> q2 = new LinkedBlockingQueue<>();
		BlockingQueue<Integer> q3 = new LinkedBlockingQueue<>(capacity);
		
		q3.add(1);
		q3.add(2);
		q3.add(3);
		//q3.add(4); //exception, Queue is full

		BlockingDeque<Integer> q4 = new LinkedBlockingDeque<>();
		BlockingDeque<Integer> q5 = new LinkedBlockingDeque<>(capacity);
		
		q5.add(1);
		q5.add(2);
		q5.add(3);
		//q3.add(4); //exception, Queue is full

		
	}

}

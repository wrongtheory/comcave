package august.woche4.tag4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> queue1 = new PriorityQueue<>();
		
		queue1.add(12);
		queue1.add(12);
		queue1.add(12);

		System.out.println("1. size: " + queue1.size());
		
		queue1.offer(-5);
		queue1.offer(222);
		queue1.offer(7);
		
		System.out.println("1. size: " + queue1.size());
		
		
		System.out.println("queue1: " + queue1);
		
		System.out.println("element" + queue1.element());
		System.out.println("peek" + queue1.peek());
		
		System.out.println("remove" + queue1.remove());
		System.out.println("pool" + queue1.poll());
		
		System.out.println("queue1: " + queue1);
		
		while(!queue1.isEmpty())
			System.out.println(queue1.remove());
		
		System.out.println("queue1: " + queue1);
		
		
		
		Queue<String> queue2 = new PriorityQueue<>();
		
		queue2.add("hh");
		queue2.add("rr");
		queue2.add("rr");
		queue2.add("mm");
		queue2.add("cc");
		
		

		System.out.println(queue2);
		
		while(!queue2.isEmpty())
			System.out.println(queue2.remove());

		
	}

}

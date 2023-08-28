package august.woche4.tag5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ArrayDequeExample {

	public static void main(String[] args) {
		
		
		/*
		 * Deque extends Queue
		 * ArrayDeque implement Deque
		 */
		
		
		Queue<Integer> queue = null;
		Deque<Integer> deque = new ArrayDeque<>();
		
		queue = deque; // Deque IS-A Queue
		
		/*
		 * tail-methoden
		 * add
		 * offer
		 */
		
		deque.add(2);
		deque.offer(3);
		deque.add(4);
		
		
		System.out.println("1. deque: " + deque);
		
		System.out.println("2. peek: " + deque.peek()); // show first
		System.out.println("3. element: " + deque.element()); // show first
		
		deque.offer(5); //[2 3 4 5]
		deque.poll();   //[3 4 5]
		deque.add(6);   //[3 4 5 6]
		deque.remove(); //[4 5 6]
		System.out.println("4.deque: " + deque);
		
		deque.push(3); // add first
		
		System.out.println("5.deque: " + deque);
		
		System.out.println("6. peek: " + deque.peek()); // show first
		
		System.out.println("7. pop: " + deque.pop()); // remove first
		
		
		System.out.println(deque.add(7)); // return true 
		System.out.println(deque.offer(8)); // return true
		System.out.println(deque.peek()); // return 4
		System.out.println(deque.peek()); // return 4
		System.out.println(deque.remove()); // return 4
		System.out.println(deque.poll()); // return 5 ( remove)
		System.out.println(deque.pop());  // return 6 (remove)
		//System.out.println(deque.push(9)); // cf return void
		

	}

}

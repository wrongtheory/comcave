package august.woche5.tag1;

import java.util.ArrayDeque;
import java.util.Deque;

public class WdhArrayDeque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//a();
		//b();
		d();
		

	}
	
	static void b() {
		// TODO Auto-generated method stub
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		System.out.print(deque.offer(1) + " ");
		System.out.print(deque.add(2) + " ");
		System.out.print(deque.peek() + " ");
		System.out.println(deque.poll());

	}
	
//	static void c() {
//		// TODO Auto-generated method stub
//		
//		Deque<Integer> deque = new ArrayDeque<>();
//		
//		System.out.print(deque.offer(1) + " ");
//		System.out.print(deque.add(2) + " ");
//		System.out.print(deque.push(3) + " ");
//		System.out.println(deque.remove());
//		System.out.println(deque.poll());
//		System.out.println(deque.pop());
//
//	}
	
	static void d() {
		// TODO Auto-generated method stub
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		System.out.print(deque.offer(1) + " ");
		System.out.print(deque.add(2) + " ");
		deque.push(3);
		System.out.print(deque.remove());
		System.out.print(deque.poll());
		System.out.print(deque.pop());

	}
	
	public static void a() {
		// TODO Auto-generated method stub
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		System.out.print(deque.offer(1) + " ");
		System.out.print(deque.add(1) + " ");
		System.out.println(deque);

	}


}

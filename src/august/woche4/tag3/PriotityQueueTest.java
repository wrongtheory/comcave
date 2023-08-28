package august.woche4.tag3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriotityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Queue<String> queue = new PriorityQueue<>();
		
		queue.add("hallo");
		queue.add("zorro");
		
		queue.add("banana");
		queue.add("manana");
		queue.add("panana");
		queue.add("allo");
		//queue.add(null); //cf
		
		System.out.println(queue);
		
		Queue<String> queue3 = new PriorityQueue<>();
		
		queue3.offer("hallo");
		queue3.offer("zorro");
		queue3.offer("banana");
		queue3.offer("manana");
		queue3.offer("panana");
		queue3.offer("allo");
		//queue.add(null); //cf
		
		System.out.println(queue3);
		

		
		queue.remove();
		
		System.out.println(queue);
		
		System.out.println(queue.poll());
		
		Queue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
		
		queue2.add(7);
		queue2.add(12);
		queue2.add(1);
		queue2.add(34);
		queue2.add(3);
		//queue2.add(null); //cf
		
		System.out.println(queue2);
		
		Queue<Integer> queue4 = new PriorityQueue<>();
		
		for(int i=0;i < 20;i++)
			queue4.add(new Random().nextInt(20));
		//queue2.add(null); //cf
		
		System.out.println(queue4);
		
		Queue<Integer> queue5 = new PriorityQueue<>();
		
		
		queue5.add(55);
		queue5.add(34);
		queue5.add(23);
		queue5.add(12);
		queue5.add(3);
		queue5.add(20);
		queue5.add(10);
		queue5.add(1);
		queue5.add(44);
		queue5.add(18);
		
		System.out.println(queue5);
		

	}

}

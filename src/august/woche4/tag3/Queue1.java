package august.woche4.tag3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 1; i <= 20; i++) {
            queue.offer(i);
        }

        System.out.println(queue);

        Queue<Integer> queue2 = new PriorityQueue<Integer>();

        for (int i = 20; i >= 1; i--) {
            queue2.offer(i);
        }


        Arrays.sort(queue2.toArray());
         
        System.out.println(queue2);
        System.out.println("size: " + queue2.size());
        
        while(!queue2.isEmpty()) 
        	System.out.println(queue2.poll());


	}

}

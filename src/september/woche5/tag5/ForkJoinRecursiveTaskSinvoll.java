package september.woche5.tag5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class CountPositive extends RecursiveTask<Integer> {
	
	private final static int THRESHOLD = 3;
	
	private int[] array;
	private int indexFrom;
	private int indexTo;
	
	public CountPositive(int[] array, int indexFrom, int indexTo) {
		this.array = array;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}
	
	protected Integer compute() {
		if(indexTo - indexFrom <= THRESHOLD) {
			System.out.printf("compute [%d .. %d] %n", indexFrom, indexTo);
			int count = 0;
			for(int i = indexFrom; i < indexTo; i++) {
				if(array[i] > 0) {
					count++;
				}
			}
			return count;
		}
		else
		{
			System.out.printf("Zu kompliziert [%d .. %d] %n", indexFrom, indexTo);
			
			int mitte = (indexFrom + indexTo) / 2;
			
			CountPositive taskLeft = new CountPositive(array, indexFrom, mitte);
			CountPositive taskRight = new CountPositive(array, mitte, indexTo);
			
			taskLeft.fork();
			Integer countRight =  taskRight.compute();
			Integer countLeft = taskLeft.join();
			
			//return countLeft + countRight;
			//return taskLeft.join() + taskRight.compute();
			taskLeft.compute();
			//taskRight.compute();
			//return taskLeft.compute() + taskRight.join();
		}

	}
}

public class ForkJoinRecursiveTaskSinvoll {

	public static void main(String[] args) {
		
		int[] array = {-3, 7, 22, -5, 8};
		
		ForkJoinPool pool = new ForkJoinPool();
		
		Integer anzahlPositive =  pool.invoke(new CountPositive(array, 0, array.length));

		System.out.println("Anzahl positive Werte: " + anzahlPositive);
	}

}

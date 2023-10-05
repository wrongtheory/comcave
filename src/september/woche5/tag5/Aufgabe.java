package september.woche5.tag5;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class ZahlenBereich extends RecursiveAction {
	
	private static final int THRESHOLD = 3;
	private int[] array;
	private int indexFrom, indexTo;

	public ZahlenBereich(int[] array, int indexFrom, int indexTo) {
		this.array = array;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	protected void compute() {
		if((indexTo - indexFrom) < THRESHOLD) {
			//System.out.println("indexFrom: " + indexFrom );
			//System.out.println("indexTo: " + indexTo );
			//System.out.printf("compute: %d .. %d %n", indexFrom, indexTo);
			System.out.printf("Unterbereich %d .. %d %n", array[indexFrom], array[indexTo-1]);

//			for(int i = indexFrom; i <= indexTo; i++)
//				System.out.print(array[i] + " ");
//			System.out.println();
		}
		else {
			
			//System.out.printf("zu kompliziert: [%d .. %d] %n", indexFrom, indexTo);
			//System.out.println("indexFrom: " + indexFrom );
			//System.out.println("indexTo: " + indexTo );

			
			int middle = (indexFrom + indexTo) / 2;
			//System.out.println("middle: " + middle);
			RecursiveAction actionLeft  =  new ZahlenBereich(array, indexFrom, middle);
			RecursiveAction actionRight =  new ZahlenBereich(array, middle, indexTo);
			
			invokeAll( actionLeft, actionRight);
		}
		
	}
}

class ZahlBereichRecursiveTask extends RecursiveTask<int[]> {

	int[] array;
	static final int THRESHOLD = 3;
	int indexFirst, indexLast;
	
	
	
	public ZahlBereichRecursiveTask(int[] array, int indexFirst, int indexLast) {
		this.array = array;
		this.indexFirst = indexFirst;
		this.indexLast = indexLast;
	}



	@Override
	protected int[] compute() {
		
		if((indexLast - indexFirst) < THRESHOLD) {
			int[] arr = new int[array.length];
			System.out.printf("Unterbereich %d .. %d %n", array[indexFirst], array[indexLast-1]);
			arr[indexFirst] = array[indexFirst];
			arr[indexLast-1] = array[indexLast-1];
			return arr;
		}
		
		else {
			int middle = (indexFirst + indexLast) / 2;
			
			ZahlBereichRecursiveTask taskLeft = new ZahlBereichRecursiveTask(array, indexFirst, middle);
			ZahlBereichRecursiveTask taskRight = new ZahlBereichRecursiveTask(array, middle, indexLast);
			
			//taskLeft.fork();
			taskRight.fork();
			
//			int[] a = taskRight.compute();
//			int[] b = taskLeft.join();
			
			//invokeAll(taskLeft, taskRight);
			
			taskLeft.compute();
			taskRight.join();
			
		}
		
		return null;
	}
	
}

public class Aufgabe {

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		//int[] array = {5,8,3,4,1,9,2,7,4,7,5,8,0,2,6,0,1,9,4,5,7,4};
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(new ZahlenBereich(array, 0, array.length));
		System.out.println("**************************************************");
		
		//System.out.println(array);
		ForkJoinPool pool2 = new ForkJoinPool();
		pool2.invoke(new ZahlBereichRecursiveTask(array, 0, array.length));


	}

}

package september.woche5.tag5;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ReplaceNegative extends RecursiveAction {
	
	private int[] array;
	static final int THRESHOLD = 1;
	private int indexFrom, indexTo;

	public ReplaceNegative(int[] array, int indexFrom, int indexTo) {
		this.array = array;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	protected void compute() {
		
		if((indexTo-indexFrom) <= THRESHOLD) {
			System.out.printf("commpute [%d .. %d] %n", indexFrom, indexTo);
			for(int i = indexFrom; i < indexTo; i++) {
				if(array[i] < 0)
					array[i] = 0;
			}
		} else {
			System.out.printf("zu kompliziert [%d .. %d] %n", indexFrom, indexTo);
			
			int mitte = (indexFrom + indexTo) / 2;
			RecursiveAction actionLeft  =  new ReplaceNegative(array, indexFrom, mitte);
			RecursiveAction actionRight =  new ReplaceNegative(array, mitte, indexTo);
			
			invokeAll(actionLeft, actionRight);
		}
	}
	
}

public class ForkJoinRecursiveActionSinvoll {

	public static void main(String[] args) {
		
		int[] array = {-3, 7, 22, -5, 8};
		
		ForkJoinPool pool = new ForkJoinPool();
		
		pool.invoke(new ReplaceNegative(array, 0, array.length));
		
		System.out.println("array: " + Arrays.toString(array));

	}

}

package september.woche5.tag3;

import java.util.Arrays;

public class Aufgabe2 {
static int v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] array = {'a','b','c','d','e'};
		int pointer = 5;
		
		permutate(array, pointer);
		System.out.println(v);
	}

	public static void permutate(char[] arr, int pointer) {
	
	    if(pointer==1) {
	    	v++;
	        System.out.printf("%s %n", Arrays.toString(arr));
	        return;
	    }

	    for (int i = 0; i < pointer-1; i++) {
	       permutate(arr, pointer-1);

	        if(pointer%2==0) {
	            char tmp = arr[pointer-1];
	            arr[pointer-1] = arr[i];
	            arr[i] = tmp;
	        } else {
	            char tmp = arr[pointer-1];
	            arr[pointer-1] = arr[0];
	            arr[0] = tmp;
	        }
	    }

	    permutate(arr, pointer-1);
	}
}

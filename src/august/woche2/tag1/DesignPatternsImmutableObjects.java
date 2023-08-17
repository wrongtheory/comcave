package august.woche2.tag1;

import java.util.Arrays;
import java.util.Random;

final class MyValues {
	
	//Immutable Objects. Klasse gut kapseln
	
	private final int[] values;
	
	//Immutable Objects, Refernz-Parameter defensiv behandeln

	public MyValues(int...values) {
		super();
		//this.values = values;
		
		this.values = Arrays.copyOf(values, values.length); // defensiv
	}
	//Immutable Objects. Mutable Referenz Ruckgaben defensiv behandeln
	public int[] getValues() {
		//return values;
		return Arrays.copyOf(values, values.length); //defensiv
	}
	
//	public void setValues(int[] values) {
//		this.values = values;
//	}
//	
	public void add(int delta) {
		for(int i=0;i<values.length;i++)
			this.values[i] += delta;
	}
	
	
}

public class DesignPatternsImmutableObjects {

	public static void main(String[] args) {
		
	int[] arr = {1,2,3};
		
	//MyValues v1 = new MyValues(arr);
	MyValues v1 = createMyValues(arr);
	MyValues v11 = new MyValues(arr);
	
	
	System.out.println(Arrays.toString(v1.getValues())); // Zeile A
	
	// v1.values = new int[]{} // cf values private
	// v1.values[0] = -1; // cf values private
	
	arr[0] = -11;
	int[] tmp = v1.getValues();
	tmp[0] = -111;
	v11.add(5);
	System.out.println(Arrays.toString(v11.getValues()));
	}

	private static MyValues createMyValues(int...arr) {
		return new MyValues(arr);
		//return new MyRandomValues(arr);
	}

}

//class MyRandomValues extends MyValues{
//	
//	public MyRandomValues(int...values) {
//		super(values);
//	}
//	
//	public int[] getValues() {
//		int[] arr = new int[5];
//		Random rnd = new Random();
//		for(int i=0;i<arr.length;i++) {
//			arr[i] = rnd.nextInt();
//		}
//		return arr;
//	}
//}

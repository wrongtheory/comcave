package august.woche1.tag3;

import java.util.Arrays;
import java.util.Comparator;

class MyStringComparator implements Comparator<String> {
	
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}

class MyReverseComparator implements Comparator<String>{
	public int compare(String s1,String s2) {
		return s2.compareTo(s1);
	}
}

public class ComparatorExample {
	
	static Integer[][] i = new Integer[][] {{5,1,8},{9,9,4},{4,1,7}};
	
	

	public static void main(String[] args) {
		
	Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return Integer.compare(a, b);
			}
		};
		
		String[] arrStr = {"jjjj","vv","jj","tt","cc","vvvv"};
		
		System.out.println("1. arrStr: " + Arrays.toString(arrStr));
		
		Arrays.sort(arrStr);
		
		System.out.println("2. arrStr: " + Arrays.toString(arrStr));
		
		Comparator<String> cmp = new MyStringComparator();
		
		Arrays.sort(arrStr, cmp);
		
		System.out.println("3. arrStr: " + Arrays.toString(arrStr));
		
		
		cmp = new MyReverseComparator();
		//Arrays.sort(i,c);
	
		//Arrays.sort(i, c);
	
		
		System.out.println("4. arrStr: " + Arrays.deepToString(i));
		for(Integer[] m : i) {
			Arrays.sort(m,c);
			//for(Integer n : m) {
				//Arrays.sort(m,c);
				//System.out.print(n + " ");
			//}
		System.out.println();
		}
		
		System.out.println("4. arrStr: " + Arrays.deepToString(i));
		
		for(int q = 0; q < i[0].length; q ++) {
			int e = 0;
			for(int w = 0; w < i.length; w++) {
				i[q][w] = i [w][e];
				
			}
			Arrays.sort(i[q],c);
			
		}
		
		for(int q =0; q< i.length; q ++) {
			//int e =0 ;
			for(int w=0; w<i[q].length; w++) {
				System.out.print(i[q][w] + " ");
			}
			System.out.println();
		}
	}

	


}

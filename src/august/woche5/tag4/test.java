package august.woche5.tag4;

import java.util.ArrayList;
import java.util.List;

public class test {
	
	static List<Integer> list = new ArrayList<>() {
		
		{
			
			add(1);
			add(2);
			
		}
	};

	public static void main(String[] args) {

		{
			System.out.println(list);
		}
		
		
		List<int[]> data = new ArrayList<int[]>();
		data.add(new int[]{1,2,3});
		for(int[] a : data)
			for(int i: a)
				System.out.println(i);
		
		
	}

}

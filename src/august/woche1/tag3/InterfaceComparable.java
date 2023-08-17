package august.woche1.tag3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InterfaceComparable {

	public static void main(String[] args) {
		
		String[] arrStr = {"jjj","vvv","ttt","ccc"};

		
			//for(String t : arrStr)
			//System.out.println(t);
		System.out.println(Arrays.toString(arrStr));
		Arrays.sort(arrStr);
		
			//for(String t: arrStr)
			//System.out.println(t);
		System.out.println(Arrays.toString(arrStr));
		
		List<Integer> listInt = Arrays.asList(55,33,11,77);
		
		System.out.println(listInt);
		
		Collections.sort(listInt);
		
		
	}

}

package august.woche1.tag4;

import java.util.Arrays;
import java.util.List;

public class BoxingAndUnboxing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating an Integer Object with custom value 10
		Integer i = new Integer(10);
		Integer i2 = new Integer(20);
		
		Integer i3 = i+i2;
		int i4 = i+i2;
		
		// Unboxing the Objext
		
		int i1 = i;
		
		//Autoboxing of character
		Character gfg = 'a';
		
		//Auto-unboxing of Character
		char ch = gfg;
		
		
		int i5 = Integer.valueOf(3);
		
		
		List<Integer> list = Arrays.asList(1,2,3);
		
		int sum = 0;
		
		for(Integer i6 : list) {
			if(i6.intValue() % 2 !=0 )
				sum+=i.intValue();
		}
		
		Integer obj = new Integer(Integer.valueOf("+123"));
		int i7 = obj.intValue();
		System.out.println(i7);
		
		Long l = Long.valueOf(1);
		
		System.out.println('L' + 'O');
	}

}

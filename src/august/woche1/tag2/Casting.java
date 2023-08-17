package august.woche1.tag2;

import java.util.function.Predicate;

class Mycomparable implements Predicate<Integer>, Comparable<Integer> {

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}


public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object obj = 12;
		
		Integer v1 = null;
		
		if(obj instanceof Integer) {
			v1 = (Integer)obj;
			System.out.println("ok");
		}
		else
			throw new ClassCastException();
		
		Object obj2 = 1d;
		
		try {
		Double v2 = (Double)obj2;
		System.out.println("ok");
		}catch(ClassCastException e) {
			System.out.println("ClassCastException");
		}
		
		

		//v1.intValue();
		
		
		Integer ref1 = 12;
		//Double ref2 = (Double)ref1;
		
		Predicate<Integer> ref3 = new Mycomparable();
		Comparable<Integer> ref4 = (Comparable<Integer>)ref3;
		
		Predicate<Integer> ref5 = (Predicate<Integer>)ref4;
		
		Object ref6 = "Moin";
		
		Comparable<String> ref7 = (Comparable<String>)ref6;
		
		Predicate<String> ref8 = (Predicate<String>)ref6;
	}

}


package august.woche.tag1.methodref;

import java.util.Optional;

public class OptionalExample {
	
	//Ohne Optional
	
//	static Integer add(int a, int b) {
//		long result = (long) (a+b);
//		
//		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
//			throw new IllegalArgumentException("int- Overflow" + a + " + " + b + " = " + result);
//		}
//		
//		return (int)result;
//	}
//
//	//Ohne optional ohne exception
//	static Integer add2(int a, int b) {
//		long result = (long) a+b;
//		
//		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
//			return null;
//		}
//		
//		return (int)result;
//	}
//	
//	
	static Optional<Integer> add3(int a, int b) {
		long result = (long) a+b;
		
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return Optional.empty();
		}
		
		return Optional.of((int)result);
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 1;
		int b = Integer.MAX_VALUE;
		// int result = add3(a, b); // cf
		
		Optional<Integer> result = add3(a, b);
		//result.ifPresent(System.out::println);
		if(result.isEmpty()) {
			System.out.println("keine summe");
		}
		else {
			result.get();
		}
		
		Integer res = add3(a,b).orElse(0);
		System.out.println(res);
		
		
		//System.out.println(result);
	}

}

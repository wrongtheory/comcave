package august.woche2.tag3.functionalInterfaces;

import java.util.List;
import java.util.function.Supplier;

public class SupplierFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Supplier<String> s1 = new Supplier<String>() {
			public String get() {
				return "mi";
			}
		};
		
		System.out.println(s1.get());
		
		Supplier<String> s2 = () -> {
			return "mi";
		};
		
		System.out.println(s2.get());
		
		Supplier<String> s3 = () -> "mi";
		
		System.out.println(s2.get());
		
	}
	
	static boolean test(int value, RuntimeException ex) {
		if(value > 0) {
			return true;
		} else {
			throw ex;
		}
	}
	
	static boolean test(int value, Supplier<RuntimeException> ex) {
		if(value > 0) {
			return true;
		} else {
			throw ex.get();
		}
	}

}

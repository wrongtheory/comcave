package august.woche5.tag4;

class MyUtils {
	static <T> void m1(T a, T b) {
		
	}
	

}

public class GenericsMethodeAufrufe {

		public static void main(String[] args) {
		
		
		MyUtils.m1(12, 44);
		MyUtils.m1(true, 44);
		MyUtils.<Object>m1(true,44);
		

	}

}

package august.woche5.tag4;

import java.util.function.BiConsumer;

public class MethodeReferenceBiConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiConsumer<Integer, String> bc = MethodeReferenceBiConsumer::m;

		
		bc.accept(12, " ist gerade");
		
	}
	
	static void m(Integer x, String s) {
		System.out.println(x + " " + s);
	}

}

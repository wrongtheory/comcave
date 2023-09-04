package august.woche5.tag3;

import java.util.ArrayDeque;
import java.util.Collection;

class CustomGenericClassA<T> {
	T att;
	
	T m(T t){
		T localVar = null;
		
		return t;
	}
}

class CustomGenericClassB<T extends Number> {
	T att;
	
	double m(T t){
		T localVar = null;
		
		return t.doubleValue();
	}
}

//class CustomGenericClassC <?> {
//	? att;
//	
//	? m(? t){
//		? localVar = null;
//		
//		return t;
//	}
//}





public class EigeneGenerischeKlasse {

	public static void main(String[] args) {
		
		
		Collection<?> myVar = new ArrayDeque<>();

	}

}

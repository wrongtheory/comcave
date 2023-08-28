package august.woche4.tag1;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OPtionalAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Optional<Integer> op1 = Optional.empty();
		System.out.println(op1);
		
		Optional<Integer> op2 = Optional.of(2);
		System.out.println(op2);
		
		Optional<Integer> op3 = Optional.ofNullable(null);
		System.out.println(op3);
		
		Optional<Integer> maybeInt = Optional.of(42);
		if(maybeInt.isPresent()) {
			Integer value = maybeInt.get();
			System.out.println(value);
		}
		
		maybeInt = Optional.empty();
		
		try {
			maybeInt.get();
		}catch(NoSuchElementException e){
			System.out.println("exception");
		}
		
		System.out.println(maybeInt);
		maybeInt.ifPresent(value -> System.out.println("value" + value));
		
		maybeInt = Optional.of(12);
		maybeInt.ifPresent(value -> System.out.println("value " + value));
		
		maybeInt.ifPresent(System.out::print);
		maybeInt.ifPresentOrElse(System.out::print);
		

	}
	
	static Optional<Path> getParent(String elementPath) {
		return Optional.ofNullable(Paths.get(elementPath).getParent());
	}  

}

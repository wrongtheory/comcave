package august.woche5.tag4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CollectionRemoveIfStreamParallelStream {

	public static void main(String[] args) {
		
		Collection<String> coll = Arrays.asList("mo","di","mi","do");
		
		coll = new ArrayList<>(coll);
		
		//coll.stream();
		//coll.parallelStream();

		Predicate<String> p1 = x -> x.indexOf('d') != -1;
		
		//for(String s : coll)
			//p1.test(s);
		
		coll.removeIf(p1);
		System.out.println(coll.size());
		System.out.println(coll);
		
		kleineAufgabe();
	}
	
	static void kleineAufgabe() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		list = new ArrayList<>(list);
		
		list.removeIf(x -> x % 2 != 0);
		
		System.out.println(list);
	}

}

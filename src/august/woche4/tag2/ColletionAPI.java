package august.woche4.tag2;

import java.util.ArrayList;
import java.util.Collection;

public class ColletionAPI {

	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<>();
		
		System.out.println("1.size" + coll.size());
		
		coll.add("mo");
		coll.add("di");
		coll.add(new String("asd"));
//		coll.add(12); // cf: String param = 12;
		
		boolean b = coll.remove(12);
		System.out.println(b);
		
		coll.remove(new String("di"));

	}

}

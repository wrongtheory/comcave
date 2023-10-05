package september.woche5.tag3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WDHCopyOnWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new CopyOnWriteArrayList<>();
		
		list.add("mo");
		list.add("di");
		
		Iterator<String> it = list.iterator();
		
		list.add("mi");
		list.add("do");
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(list);
		
		//a();

	}
	
	static void a() {
		List<String> list = new ArrayList<String>();
		
		list.add("mo");
		list.add("di");
		
		Iterator<String> it = list.iterator();
		
		list.add("mi");
		list.add("do");
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}

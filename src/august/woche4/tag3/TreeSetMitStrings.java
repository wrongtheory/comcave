package august.woche4.tag3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMitStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new TreeSet<>();
		
		set.add("ggg");
		set.add("ggg");
		set.add(new String("ggg"));

		System.out.println("1.size: " + set.size());
		
		set.add("bbb");
		set.add("mmm");
		set.add("aaa");
		
		System.out.println("2.size: " + set.size());
		
		System.out.println("set: " + set);
		
		
		System.out.println("\n TreeSet(Comparator");
		Comparator<String> cmp = (s1, s2) -> s2.compareTo(s1);
		set = new TreeSet<>(cmp);
		
		
		set.add("dd");
		set.add("dd");
		set.add("mm");
		set.add("aa");
		
		
		System.out.println(set);
		
		
		
	}

}

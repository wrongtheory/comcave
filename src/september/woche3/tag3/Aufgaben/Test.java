package september.woche3.tag3.Aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum words{en,de,psw}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> en = Arrays.asList("aa","bbb","ccc");
		List<String> de = Arrays.asList("eeee","fffff");
		
		List<List<String>> com = new ArrayList<>();
		com.add(en);
		com.add(de);
		
		System.out.println(com);
		
		for(int i=0;i<com.size();i++)
			System.out.println(com.get(i) + " " + com.get(i).size());
		
		
	Map<Object, List<Object>> m =	com.stream()
			.collect(Collectors.groupingBy(List::stream, Collectors.mapping(List::stream, Collectors.toList())));
	
	System.out.println(m);
		
	}

}

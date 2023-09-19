package september.woche3.tag3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsWeitere {

	public static void main(String[] args) {
		
		List<String> listStr = Arrays.asList("mo","di","mi");
		
		String result =  listStr.stream().collect(Collectors.joining());

		System.out.println("result: "+result);
		
		result =  listStr.stream().collect(Collectors.joining(","));

		System.out.println("result: "+result);
		
		result =  listStr.stream().collect(Collectors.joining(",","[","]"));

		System.out.println("result: "+result);
		
		
		
	}

}

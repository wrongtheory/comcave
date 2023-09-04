package august.woche5.tag4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StackProblem {

	public static void main(String[] args) {
		
		
		ArrayList<String[]> listOfStringArrays = new ArrayList<String[]>();
        listOfStringArrays.add(new String[] {"x","g","z"});
        listOfStringArrays.add(new String[] {"a","b","c"});
        listOfStringArrays.add(new String[] {"m","a","o"});
        Collections.sort(listOfStringArrays,new Comparator<String[]>() {
            public int compare(String[] strings, String[] otherStrings) {
                return strings[1].compareTo(otherStrings[1]);
            }
        });
        for (String[] sa : listOfStringArrays) {
            System.out.println(Arrays.toString(sa));
        }

	}

}

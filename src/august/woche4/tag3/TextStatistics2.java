package august.woche4.tag3;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class TextStatistics2 {

	private static Collection<Character> coll = new LinkedHashSet<>();

	private static TextStatistics2 of(String string) {
		for (int i = 0; i < string.length(); i++) {
			coll.add(string.charAt(i));
		}
		return new TextStatistics2();
	}

	Collection<Character> getUniqueChars() {
		return coll;
	}

	public static void main(String[] args) {

		TextStatistics2 stat = TextStatistics2.of("aaabbbbcccdaabbaacccddd");

		Collection<Character> chars = stat.getUniqueChars();

		System.out.println(chars);
		chars.forEach(System.out::print);
		
		System.out.println();
		for(char c : chars)
			System.out.print(c + " ");

	}

}

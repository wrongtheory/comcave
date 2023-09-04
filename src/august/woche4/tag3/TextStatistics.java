package august.woche4.tag3;

import java.util.Collection;
import java.util.HashSet;

public class TextStatistics {

	private Collection<Character> coll = new HashSet<>();

	private TextStatistics of(String string) {
		for (int i = 0; i < string.length(); i++) {
			coll.add(string.charAt(i));
		}
		return this;
	}

	Collection<Character> getUniqueChars() {
		return coll;
	}

	public static void main(String[] args) {

		TextStatistics stat = new TextStatistics().of("abcdaaaacccddd");

		Collection<Character> chars = stat.getUniqueChars();

		System.out.println(chars);
		
		chars.forEach(System.out::print);
		
		System.out.println();
		
		for(char c : chars)
			System.out.print(c + " ");

	}

}

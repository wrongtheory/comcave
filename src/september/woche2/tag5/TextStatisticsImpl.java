package september.woche2.tag5;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextStatisticsImpl implements TextStatistics{
	
	String text;
	
	public TextStatisticsImpl(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	//-----------------------------A1--------------------------------//

	@Override
	public int getCountChars() {
		
		int c =  (int)text.chars().count();
		
//	Integer c =	Stream.of(text)
//			.flatMap(x -> Stream.of(x.split(" ")))
//			.map(x -> x.length())
//			.reduce((a,b) -> a + b).get();
//		
//	Integer size = Stream.of(text)
//			.flatMap(Pattern.compile(" ")::splitAsStream)
//			.map(x -> x.length())
//			.reduce((a,b) -> a + b).get();
	System.out.println("Count chars: " + c);
		return c;
	}

	@Override
	public int getCountSpecialChars() {
//		return (int)text.chars()
//					.mapToObj(x -> (char)x)
//					.filter(x -> !Character.isLetterOrDigit(x))
//					.count();
	Long count = text.chars()
			.mapToObj(x -> (char)x)
			.filter(x -> !Character.isLetterOrDigit(x))
			.count();	
	System.out.println("Special chars: " + count);
		return count.intValue();
	}

	@Override
	public int getCountLetters() {
		
	Long count = text.chars()
			.mapToObj(x -> (char)x)
			.filter(x -> Character.isLetter(x))
			.count();		
	System.out.println("Letters: " + count);
		return count.intValue();
	}

	@Override
	public Optional<String> getLongestWord() {
		
	Optional<String> op =  Stream.of(text)
			.flatMap(x -> Stream.of(x.split(" ")))
			.reduce((a,b) -> a.length() > b.length() ? a : b);
	System.out.println("Longest Word: " + op.get());
		return op;
	}
}

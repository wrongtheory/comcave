package september.woche2.tag5;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
	TextStatisticsImpl textstats = 	new TextStatisticsImpl("ab cb d*8$23!!/+dsas& fds");
	
	String[] input = {
			"String 1",
			"Heute ist Montag",
			"Java ist toll"
	};
	
	System.out.println("*******************A1******************************");

	System.out.println("Text: '" + textstats + "' -> Length: " + textstats.toString().length());
	
	int getcountchars =  textstats.getCountChars();
	int specialchars = textstats.getCountSpecialChars();
	int letters = textstats.getCountLetters();
	String longestWord =  textstats.getLongestWord().get();

//	System.out.println("Text: '" + textstats + "' -> Length: " + textstats.toString().length()+
//			"\nCount chars: " + getcountchars + 
//			"\nSpecial chars: " + specialchars + 
//			"\nLetters: " + letters +
//			"\nLongest Word: " + longestWord + " -> length: " + longestWord.length());
	
	System.out.println("*******************A2******************************");
	
//			Arrays.stream(input)
//				.forEach(x -> {
//					System.out.println("Text: " + "'" + x +"'");
//					new TextStatisticsImpl(x).getCountChars();
//					new TextStatisticsImpl(x).getCountSpecialChars();
//					new TextStatisticsImpl(x).getCountLetters();
//					new TextStatisticsImpl(x).getLongestWord();
//				});
			
			TextStatistics idt = new TextStatisticsImpl("");
			BiFunction<TextStatistics, String, TextStatistics> acc = (a,b) -> {
				TextStatistics statsNew = new TextStatisticsImpl(b);
				
				return new CombinedTextStatistics(a,statsNew);
			};
			BinaryOperator<TextStatistics> cmb = (a,b) -> new CombinedTextStatistics(a, b);
			
			TextStatistics st = Arrays.stream(input)
					.reduce(idt, acc, cmb);
			
			st.getCountChars();
//			st.getCountSpecialChars();
//			st.getCountLetters();
//			st.getLongestWord();
	} //end main
}

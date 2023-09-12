package september.woche2.tag5;

import java.util.Optional;

public class CombinedTextStatistics implements TextStatistics{

	private TextStatistics statA, statB;

	public CombinedTextStatistics(TextStatistics statA, TextStatistics statB) {
		this.statA = statA;
		this.statB = statB;
	}

	@Override
	public int getCountChars() {
		// TODO Auto-generated method stub
		return statA.getCountChars() + statB.getCountChars();
	}

	@Override
	public int getCountSpecialChars() {
		// TODO Auto-generated method stub
		return statA.getCountSpecialChars() + statB.getCountSpecialChars();
	}

	@Override
	public int getCountLetters() {
		// TODO Auto-generated method stub
		return statA.getCountLetters() + statB.getCountLetters();
	}

	@Override
	public Optional<String> getLongestWord() {
		// TODO Auto-generated method stub
		
		Optional<String> op1 = statA.getLongestWord();
		Optional<String> op2 = statB.getLongestWord();
		
		if(op1.isEmpty()) {
			return op2;
		}
		
		if(op2.isEmpty()) {
			return op1;
		}
		
		String s1 = op1.get();
		String s2 = op2.get();
		
		int res = CMP_STRING_DEFAULT.compare(s1, s2);
		
		if(res>0)
			return op1;
		return op2;
		//return Optional.empty();
	}


}
	
	

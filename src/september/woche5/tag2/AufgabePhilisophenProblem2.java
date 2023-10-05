package september.woche5.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabePhilisophenProblem2 {

	public static void main(String[] args) {
		
		String[] namen = {"Nietzsche",
				"Aristoteles",
				"Protagoras",
				"Decartes",
				"Protagoras",
				"kant",
				"Hegel",
				"Beauvoir",
				"Ahrendt"};
		
		List<Philosoph> philosophen = Arrays.stream(namen)
				.map(Philosoph::new)
				.collect(Collectors.toList());
		
		List<Lock> locks = Stream.generate(ReentrantLock::new)
				.limit(philosophen.size())
				.collect(Collectors.toList());
	
		for(int i=0;i<philosophen.size();i++) {
			Philosoph p = philosophen.get(i);
			Lock leftLock = locks.get(i);
			p.setLeftLock(leftLock);
			Lock rightLock = locks.get((i+1) % philosophen.size());
			p.setRightLock(rightLock);
		}
		
		//philosophen.forEach(Philosoph::start);
		philosophen.forEach(p -> p.start());

	}

}

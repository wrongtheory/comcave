package september.woche5.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabePhilisophenProblem {

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
		
		List<Object> gabeln = Stream.generate(Object::new)
				.limit(philosophen.size())
				.collect(Collectors.toList());
	
		for(int i=0;i<philosophen.size();i++) {
			Philosoph p = philosophen.get(i);
		    Object linkeGabel = gabeln.get(i);
			//Object rechteGabel = gabeln.get(i+1 % philosophen.size()-1);
			//p.setLinkeGabel(linkeGabel);
		    //System.out.println(linkeGabel+" " +rechteGabel);
			int index = i < gabeln.size()-1 ? i + 1 : 0;
			//Object rechteGabel = gabeln.get(index);
			Object rechteGabel = gabeln.get((i+1) % philosophen.size());
			//p.setRechteGabel(rechteGabel);
		
		}
		
		//philosophen.forEach(Philosoph::start);
		philosophen.forEach(p -> p.start());
		
//		Philosoph p1 = new Philosoph("Sokrates");
//		Philosoph p2 = new Philosoph("Platon");
//		
//		Object g1 = new Object();
//		Object g2 = new Object();
//		
//		p1.setLinkeGabel(g1);
//		p1.setRechteGabel(g2);
//		
//
//		p2.setLinkeGabel(g2);
//		p2.setRechteGabel(g1);
//
//		
//		p1.start();
//		p2.start();
	}

}

package august.woche5.tag2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Tier{
	
	private int alter;
	
	public static void meth() {
		System.out.println("m von Tier");	
	}
	
	public int getAlter() {
		return alter;
	}
}
class Katze extends Tier{}
class Hund extends Tier{}
class Wildhund extends Hund{}

public class Platzhalter {

	public static void main(String[] args) {
		
		
		Collection<Integer> c1 = new ArrayList<>();
		Collection<Number> c2 = new ArrayDeque<>(c1);
		
		
		
		/*
		 * List<Hund>
		 */
		List<Hund> listHunde = new ArrayList<>();
		
		listHunde.add(new Hund());
		//listHund.add(new Katze()); // cf
		//listHund.add(new Tier()); // cf
		//listHunde(new Wildhund());
		listHunde.add(new Wildhund());
		
		addHunde(listHunde);
		
		print(listHunde);
		
		/*
		 * Set<Katze>
		 */
		Set<Katze> setKatzen = new HashSet<>();
		
		setKatzen.add(new Katze());
		//setKatzen.add(new Hund()); // cf
		
		// addHunde(setKatzen); //cf
		print(setKatzen); 
		/*
		 * Deque<Wildhund>
		 */
		Deque<Wildhund> dequeWildhunde = new ArrayDeque<Wildhund>();
		dequeWildhunde.add(new Wildhund());
		//dequeWildhunde.add(new Hund()); // cf
		
		//addHunde(dequeWildhunde); //cf
		print(dequeWildhunde); 
		
		/*
		 * Collection<Tier>
		 */
		
		Collection<Tier> collTiere = new LinkedHashSet<>();
		
		addHunde(collTiere);
		
		print(collTiere);
		
	}
	
	static void addHunde(Collection<? super Hund> coll) {
		coll.add(new Hund());
		coll.add(new Hund());
		coll.add(new Wildhund());
		//coll.add(new Katze()); // cf
		coll.add(new Tier());
		
		Tier t = new Hund();
		coll.add((Hund) t); //cf
		
	}
	
	static void print(Collection<? extends Tier> coll) {
		System.out.println("Die Liste hat " + coll.size());
		///coll.add(new Hund()); //cf

//		for(Tier r : coll) {
//			r.meth();
//		}
	}

}

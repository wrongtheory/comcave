package august.woche1.tag4;

import java.awt.RenderingHints;
import java.util.Comparator;
import java.util.function.Predicate;

//enum DEF extends Number{} // cf: kein extends fur Enums

enum GHI{}

// class JKL extends GHI{} // cf: enum Klasse als Basisklasse geht gar nicht

enum MNO implements Predicate<Integer>, Comparator<Integer> {
	M,N,O;

	public int compare(Integer x, Integer y) {return 0;}
	
	public boolean test(Integer x) {
		return true;
	}
}

public class EnumUndVererbung {
	
	// jede Enum Klasse erbt von der Klasse java.lang.Enum
	//das kann nicht geandert werden
	// von Enum klassen kann man nicht erben
	//enum klassen konnen beliebig viele Interfaces realisieren
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

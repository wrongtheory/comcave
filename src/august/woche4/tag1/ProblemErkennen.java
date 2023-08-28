package august.woche4.tag1;

interface TV2 {
	
}

class TVDE2 implements TV2 {}
class TVUK2 implements TV2 {}

class SteckdoseDE {
	private TVDE tv;
	
	void anschliessen(TVDE tv) {
		this.tv = tv;
	}
	
	public TVDE getTv() {
		return tv;
	}
}

class SteckdoseUK {
	private TVUK tv;
	
	void anschliessen(TVUK tv) {
		this.tv = tv;
	}
	
	public TVUK getTv() {
		return tv;
	}
}

public class ProblemErkennen {
	
	/*
	 * Aufgabe
	 * 
	 * Klassenbibliothek entwickeln
	 * 
	 * Es soll englische Steckdosen geben konnen
	 * Es soll deutsche Steckdosen geben konnen
	 * 
	 * Es soll englische Fernseher geben
	 * Es soll deutsche Fernseher geben
	 * 
	 * Es soll moglich sein Fernseher an Steckdosen anzuschliessen
	 * 
	 * Deutshce Fernseheer durfen nur an deutsche Steckdosen angeschlossen werden
	 * englische Fernseheer durfen nur an deutsche Steckdosen angeschlossen werden
	 * 
	 * Design Problem der Losung:
	 * fast identsiche Steckdosen Klassen
	 */

	public static void main(String[] args) {
	
		TVDE tvDe = new TVDE();
		TVUK tvUk = new TVUK();
		
		// tvDe = tvUk; // darf nicht kopilieren
		// tvUk = tvDe; // darf nicht kompilieren
		
		SteckdoseDE sdDe = new SteckdoseDE();
		sdDe.anschliessen(tvDe);
		// sdDe.anschliessen(tvUk); // darf nicht kompilieren
		
		SteckdoseUK sdUk = new SteckdoseUK();
		//sdUk.anschliessen(tvDe); // darf nicht kompilieren
		sdUk.anschliessen(tvUk); 
		
		//sdDe = sdUk; // darf nicht kompilieren
		//sdUk = sdDe; // darf nicht kompilieren
	}

}

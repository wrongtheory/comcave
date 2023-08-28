package august.woche4.tag1;

interface TV{
	
}

class TVDE implements TV{
	
}

class TVUK implements TV{
	
}

class Steckdose<T extends TV> {
	private T tv;
	
	void anschliessen(T tv) {
		this.tv = tv;
	}
	
	public T getTv() {
		return tv;
	}
}

public class ProblemLoesen {
	
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

	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TVDE tvDe = new TVDE();
		TVUK tvUk = new TVUK();
		
		// tvDe = tvUk; // darf nicht kompilieren
		// tvUk = tvDe; //darf nicht kopilieren
		
		
		Steckdose<TVDE> sdDe = new Steckdose<>();
		sdDe.anschliessen(tvDe);
//		sdDe.anschliessen(tvUk); //darf nicht kompilieren
		
		Steckdose<TVUK> sdUk = new Steckdose<>();
//		sdUk.anschliessen(tvDe); // darf nicht kopilieren
		sdUk.anschliessen(tvUk);
		
//		sdDe = sdUk;
//		sdUk = sdDe;
		
//		Steckdose<String> sdSinnlos = new Steckdose<>(); // darf nicht kompilieren
//		sdSinnlos.anschliessen("bin definitiv kein Fernseher");

	}

}

package september.woche4.tag2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Defragmentierung extends Dienst {
	
	int zeitabstand;
	String laufwerk;
	static int var;
	
//	public Defragmentierung() {
//		
//	}
	
	public Defragmentierung(String name) {
		super(name);
	}

	public Defragmentierung(int zeitabstend, String laufwerk, int var) {
		//super("");
		this.zeitabstand = zeitabstend;
		this.laufwerk = laufwerk;
		Defragmentierung.var = var;
	}

	@Override
	public String toString() {
		return "Zeitabstand(" +zeitabstand + "), " + "LW("+laufwerk+") " + var;
	}
	


}

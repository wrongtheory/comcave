package august.woche1.tag4;

public class WrapperKlassenAutoboxingAutorunboxing {

	public static void main(String[] args) {
		
		
		// Autoboxing generierte Aufruf der statischen valueOf Methode
		//um statt eines primitiven Wert eine Referenz zu bekommen
		
		Integer ref1 = 12; // Integer ref1 = Integer.valueOf(12);
		
		//Autounboxing: generierte Aufruf der Instanzmethode xxxValue,
		//um statt einer Referenz einen primitiven Wert zu bekommen
		
		int x1 = ref1; // int x1 = ref1.intValue();
		
		//Vorteile: weniger Code
		
		Integer ref2 = 12; // 
		ref2++;  // ref2 = Integer.valueOf(ref2.intValue() +1);
		
		//In Achtung bei den Vergleichsoperatoren! (== und !=)
		//Wenn ein Operand primitv ist wird der andere Operand autoungeboxt
		
		//Wenn beide Operatoren Referenzen sind wirde der andere Operand
		//autoungeboxt und es kommt zum Verglecih der primitiven Werte
		
		//Wenn beide Operatoren Referenzen sind bleibt es beim Referenzenverglceich
		
		
		Integer v1 = 12;
		int v2 = 12;
		Double v3 = 12.0;
		
		System.out.println(v1 == v2); // Autounboxing fur v1 dann Vergleich der primitiven
		
		
		System.out.println(v3 == v2); // Autounboxing fur v3 dann Vergleich der primitiven
		
//		System.out.println(v1 == v3); // cf Referenzenvergleihc mit Geschwisterklassen Typen
		
		
		
		
		
		
	}

}

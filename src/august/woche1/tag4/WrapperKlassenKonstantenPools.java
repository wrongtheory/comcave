package august.woche1.tag4;

public class WrapperKlassenKonstantenPools {

	public static void main(String[] args) {
		
		// Beim Boxing (oder Autoboxing) mird die Methode
		// valueOf verwendet
		
		// In den Wrapper Klassen gibt es Konstanten Pools
		// Byte,Short,Integer,Long,Boolean,Character
		
		//Die valueOf Methoden deiser Klassen konnen das Objekt aus dem Konstanten Pool liefern
		
		//Speziell fur Short,Integer,Long
		//wen das Argument den Wert [-128 .. 127] hat
		//liefert valueOf ein Objekt aus dem Konstanten Pool
		//sonst wird ein neues Objekt erzeugt
		
		//Fur Byte: valueOF liefert immer ein Onjekt au dem Konstanten Pool
		
		//Fur Character:
		//wen das Argument den Wert [-128 .. 127] hat
		//liefert valueOf ein Objekt aus dem Konstanten Pool
		//sonst wird ein neues Objekt erzeugt
		
		//Fur Boolean valueOf liefert entweder Boolean.TRUE oder Boolean.FALSE
		
		
		//Autoboxing mit Integer.valueOf(12) liefert Objekt aus dem Integer Pool
		Integer x1 = 12; Integer.valueOf(12);
		Integer x2 = 12;
		
		
		System.out.println("x1 == x2: " + (x1 ==x2)); // true
		// Autoboxing mit Integer.valueOf(1200) erzeugt ein neues Objekt
		Integer x3 = 1200;
		Integer x4 = 1200;
		
		System.out.println("x3 == x4: " + (x3 == x4));
		
		Long l1 = 400l;
		Long l2 = 400l;
		
		System.out.println(l1==l2);
		
		
		

	}

}

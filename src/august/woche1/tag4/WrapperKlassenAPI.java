package august.woche1.tag4;

public class WrapperKlassenAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Konstruktoren (in Java 8 noch nicht 'deprecated')
		//Konstruktor mit dem primitiven Parameter
		//parsender Konstruktor mit dem String Parameter (ausser Character)
		
		
		new Integer(12);
		Integer i = new Integer("12");
		System.out.println(i);
		
		
		new Boolean(true);
		new Boolean("moin");
		
		// statische 'valueOf' mit dem primitiven Parameter
		// die eine Wrapper Klassen Referenz liefert
		// Boxing
		
		Integer v1 = Integer.valueOf(12);
		Boolean v2 = Boolean.valueOf(true);
		
		//parsende statische 'valueOf' mit dem String Parameter
		//die eine Wrapper Klassen Referenz liefert
		
		Integer v3 = Integer.valueOf(12);
		Double v4 = Double.valueOf("33.5");
		
		// statische parsende 'pasrseXxx' mit dem String Parameter
		// die einen Primitiven Wert liefert
		
		int v5 = Integer.parseInt("+33");
		boolean v6 = Boolean.parseBoolean("TrUe");
		
		System.out.println(v5);
		System.out.println(v6);
		
		
		try {
			Integer.parseInt("dsadas");
		}catch(NumberFormatException e) {
			System.out.println("Number format exception");
		}
		
		//Instanzmethode xxxValue die den primitiven Wert liefert
		// Unboxing
		
		Integer v7 = 42;
		int v8 = v7.intValue();
		
		//Number ist die Basisklasse fur Byte, Short, Integer, Long, Float, Double
		
		Double v9 = 12.3;
		Number v10 = v9; //Number <- IS-A <- Double
		
		//Character hat viele spezielle Methoden
		
		
		boolean result = Character.isDigit('6');
		System.out.println("is 6 a digit? : " + result);
		
		
		
		
		
		
	}

}

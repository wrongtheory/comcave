package august.woche2.tag1;

class AppSettings_V1 {
	
	//Singleton: eine statische Referenz ermoglicht den Zugriff auf das einzige Objekt
	public static final AppSettings_V1 instance = new AppSettings_V1();
	
	//Singleton: private Konstruktor verbietet das Erzeugen weiterer Objekte
	
	private AppSettings_V1(){
		System.out.println("single");
	}
	
	//Weitere Elemente der Klasse die mit dem Singleton nichts zu tun haben
	String getAppPath() {
		return "/home/vleunti";
	}
	
	

}

// 'lazy' singleton (!nicht threadsicher)
//	das Objekt wirnd nur dann erzeugt wnn man darauf zugreift

class AppSettings_V2 {
	private static AppSettings_V2 instance = null;
	
	private AppSettings_V2() {System.out.println("singl2");}
	
	public static AppSettings_V2 getInstance() {
		if(instance == null) {
			instance = new AppSettings_V2();
		}
		return instance;	
	}
}


enum AppSetings_V3{
	INSTANCE;
}

public class DesignPatternSingleton {

	public static void main(String[] args) {
	
	
		//AppSettings_V1 s33 = new AppSettings_V1();
		AppSettings_V1 s = AppSettings_V1.instance;
		AppSettings_V1 s3 = AppSettings_V1.instance;
		
		AppSettings_V2 s2 = AppSettings_V2.getInstance();
		AppSettings_V2 s22 = AppSettings_V2.getInstance();
		
		
		AppSetings_V3 v3 = AppSetings_V3.INSTANCE;

	}

}

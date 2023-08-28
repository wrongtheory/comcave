package august.woche4.tag1;

import java.time.LocalDate;
import java.time.LocalTime;

interface Fahreuz {
}

class PKW implements Fahreuz {
}

class LKW implements Fahreuz {
}

class Garage<T extends Fahreuz> {
	private T fahreug;

	void reinfahren(T fahreug) {

		this.fahreug = fahreug;

		if (fahreug.getClass() == PKW.class)
			System.out.println("Ein PkW ist am " + LocalDate.now() + " um " + LocalTime.now().getHour() + ":"
					+ LocalTime.now().getMinute() + " in der Garage reingefahren");
		else
			System.out.println("Ein LKW ist am " + LocalDate.now() + " um " + LocalTime.now().getHour() + ":"
					+ LocalTime.now().getMinute() + " in der Garage reingefahren");

	}

	public T getFahreug() {
		return fahreug;
	}
}

public class Bibliothek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LKW lkw = new LKW();
		LKW lkw2 = new LKW();
		PKW pkw = new PKW();
		PKW pkw2 = new PKW();

//		lkw = pkw; // doesn't compile
//		pkw = lkw; // doesn't compile

		Garage<PKW> pkwgarage = new Garage<>();
		pkwgarage.reinfahren(pkw);
		pkwgarage.reinfahren(pkw2);

//		pkwgarage.reinfahren(lkw); // doesn't compile

		Garage<LKW> lkwgarage = new Garage<>();
		lkwgarage.reinfahren(lkw);
		lkwgarage.reinfahren(lkw2);
//		lkwgarage.reinfahren(pkw); // doesn't compile

//		pkwgarage = lkwgarage; // doesn't compile
//		lkwgarage = pkwgarage; // doesn't compile

//		Garage<String> stringgarage = new Garage<>(); // doesn't compile

	}

}

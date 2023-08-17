package august.woche1.tag2;

class Person {
	static int minAlter = 0;
	
	public static int getMinAlter() {
		return minAlter;
	}
	
	int alter = 100;
	
	public int getAlter() {
		return alter;
	}
}

class Kunde extends Person{
	static int minAlter = 16;
	
	public static int getMinAlter() {
		return minAlter;
	}
	
	int alter = 55;
	
	public int getAlter() {
		return alter;
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		
		System.out.println(Person.minAlter); // 0
		System.out.println(Kunde.minAlter); // 16
		
		Person p1 = new Person();
		System.out.println(p1.minAlter);
		
		p1 = new Kunde();
		System.out.println(p1.minAlter);
		
		System.out.println(Person.getMinAlter()); // 0
		System.out.println(Kunde.getMinAlter()); // 16
		
		Kunde k1 = new Kunde();
		System.out.println(k1.getMinAlter());
		System.out.println(((Person)k1).getMinAlter());
		
		
		Person p2 = new Kunde();
		System.out.println(p2.alter); //100
		
		Kunde k3 = (Kunde)p2;
		System.out.println(k3.alter); // 55
		
		Person person = new Kunde();
		
		System.out.println(person.getAlter());
		
		Kunde kunde = new Kunde();
		System.out.println(((Person)kunde).getAlter());

	}

}

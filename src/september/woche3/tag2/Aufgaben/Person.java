package september.woche3.tag2.Aufgaben;

import java.util.Comparator;

public class Person {

    private String name;
    private String beruf;

    public Person(String name, String beruf) {
        this.name = name;
        this.beruf = beruf;
    }
    // more methods here...
    public String toString() {
        return name + " - " + beruf;
    }
    
    
    
    public String getName() {
		return name;
	}
	public String getBeruf() {
		return beruf;
	}



//	Comparator<Person> comp = Comparator.comparing(Person::getName).thenComparing(Person::getBeruf);
    


    
}

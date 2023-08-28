package august.woche3.aufgaben;

import java.util.Objects;

public class Besitzer {
	
	private String name;
	private int age;
	private Auto auto;

//	public Besitzer(String name, int age, Auto auto) {
//		this.name = name;
//		this.age = age;
//		this.auto = auto;
//	}
	
	public Besitzer(String name, int age) {
		this.name = name;
		this.age = age;

	}
	

	
	public Besitzer(Auto auto, Integer i) {
		this(auto.getBesitzer().getName(), auto.getBesitzer().getAge());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	/*
	 * @Override public String toString() { return "Besitzer [name=" + name +
	 * ", age=" + age + ", auto=" + auto + "]"; }
	 */	
	@Override
	public String toString() {
		return "Besitzer [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, auto, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Besitzer other = (Besitzer) obj;
		return age == other.age && Objects.equals(auto, other.auto) && Objects.equals(name, other.name);
	}
	

	
	

}

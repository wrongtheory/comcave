package wdh;

import september.woche5.tag1.Chopstick;

interface I{
	default String hop() {
		return "I1";
	}
	

	
	static void hhh() {
		System.out.println("I2");
	}
}

interface I2{
	default String hop() {
		return "";
	}
}

public class A implements I3{
	
	public String hop() {
		return "A";
	}
	
	private A() {}
	
	
	void go() {
		hop();
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new A();
		
		new A().go();
new A().gogo();
	}
	
	void gogo() {
		System.out.println(dostuff());
		System.out.println(I3.super.dostuff());
		System.out.println(I3.super.dostuff());
		System.out.println(this.dostuff());
		System.out.println(new A().dostuff());
		
		System.out.println(I3.hz());
		System.out.println(hz());
		System.out.println(new A().hz());
		System.out.println(this.hz());
		System.out.println();
		
	}
	public int dostuff() {
		return 43;
	}
	
	public int hz() {
		return 2;
	}

}

interface I3{
	default int dostuff() {
		return 1;
	}
	
	static int hz() {
		return 1;
	}
}

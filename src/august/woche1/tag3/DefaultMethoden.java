package august.woche1.tag3;

interface Executable {
	default void execute() {System.out.println("e1");}
}

class E1 implements Executable{
	
}

class E2 implements Executable{
	public void execute() {System.out.println("e2");}
}

interface Process {
	default void execute() {System.out.println("ep");}
}

//class MyClassA implements Process, Executable {}

class MyClassB implements Process, Executable {
	public void execute() {System.out.println("MyClass B");}
	
	void testCalss() {
		execute();
		this.execute();
		super.toString();
		MyClassB.this.execute();
		Process.super.execute();
		Executable.super.execute();
		
	}
}

public class DefaultMethoden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E1 v1 = new E1();
		v1.execute();
		new MyClassB().testCalss();
	}

}

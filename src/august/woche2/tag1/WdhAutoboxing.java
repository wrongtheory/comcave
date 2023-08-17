package august.woche2.tag1;

class Foo {
	
	int x;
	Integer y;
	
	public Foo(int x) {
		super();
		this.x = x + y;
		
		//this.y = null;
		// this.x = x + y.intValue();
		// da y mit null initialisiert wurde
		// verusrsacht y.intValue() NUllPointerException
	}
	
	
}

public class WdhAutoboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Foo(42).x);

	}

}

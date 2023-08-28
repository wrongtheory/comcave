package august.woche3.aufgaben;

import java.util.function.Supplier;

public class MyTracer {
	
	public enum Level{
		NONE, TRACE
	}
	
	private Level level;
	
	public MyTracer(Level level) {
		this.level = level;
	}
	
	public void setLevel(Level newLevel) {
		this.level = newLevel;
	}
	
//	public void trace(String message) {
//		if(level == Level.TRACE) {
//			System.out.println(message);
//		}
//	}
	
	public void trace(Supplier<String> supp) {
		if(level == Level.TRACE) {
			//System.out.println(supp.get());
			String message = supp.get();
			System.out.println(message);
		}
	}

	
	public static class Foo{
		MyTracer tracer = new MyTracer(MyTracer.Level.TRACE);
		
		public void m(String[] args) {
			tracer.trace(() -> "args length " + args.length);
			
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[] = {"a","b","c","TRACE","NONE"};
		new Foo().m(s);
	}

}

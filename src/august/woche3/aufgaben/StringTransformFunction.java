package august.woche3.aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringTransformFunction {

	public static class StringTransform {
		
		private List<Function<String, String>> list;
		
		public StringTransform() {
			list = new ArrayList<>();
		}

		public StringTransform addTransformation(Function<String, String> function) {
			list.add(function);
			return this;
		}

		public String process(String s) {
			for (Function<String, String> f : list) {
				s = f.apply(s);
			}
			
//			list.forEach(x -> x.apply(s));
			return s;
		}

	}

	public static void main(String[] args) {

		StringTransform t1 = new StringTransform()
				.addTransformation(s -> s.toUpperCase())
				.addTransformation(s -> s + "!");

		StringTransform t2 = new StringTransform()
				.addTransformation(s -> s.trim())
				.addTransformation(s -> s.substring(4, 8))
				.addTransformation(s -> s.toLowerCase())
				.addTransformation(s -> s.concat("!"));

		String s = t1.process("Hallo");
		System.out.println(s);
		
		s = t1.process("Java ist toll");
		System.out.println(s);

		s = t2.process("   QWERJAVAYASDF   ");
		System.out.println(s);

	}

}

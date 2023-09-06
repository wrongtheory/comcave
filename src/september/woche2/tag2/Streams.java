package september.woche2.tag2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<>();

		CopyOnWriteArrayList<Integer> cp = new CopyOnWriteArrayList<>();

		cp.add(1);
		cp.add(2);
		cp.add(3);

		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);

		cp.stream().filter(i -> {
			cp.add(77);
			return true;
		}).forEach(x -> System.out.println(x));

		System.out.println(list);

		System.out.println(cp);

		kleineAufgabe();

	}

	static void kleineAufgabe() {

		class Blume {
			int preis;

			Blume(int preis) {
				this.preis = preis;
			}

			public String toString() {
				return "Blume (" + preis + ")";
			}
		}
		
		Integer[] preise = { 90, 110, 200, 100 };

		Arrays.stream(preise)
			.map(preis -> new Blume(preis))
			.forEach(s -> System.out.println(s));
		

		Arrays.stream(preise)
			.map(Blume::new)
			.forEach(s -> System.out.println(s));


	}

}

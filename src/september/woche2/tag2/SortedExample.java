package september.woche2.tag2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortedExample {

	public static void main(String[] args) {
		
		Integer[] array = {55, -5, 3, 11, -1, 3};
		
		/*
		 *   Stream<T> sorted();
		 */
		
		System.out.println("sorted methode\n");
		
		Arrays.stream(array)
			.sorted()
			.forEach(a -> System.out.println(a));
		
		
		/*
		 *  Stream<T> sorted(Comparator<? super T> comparator);
		 *  public interface Comparator<T>
		 *   int compare(T o1, T o2);
		 */
		
		System.out.println("\nsorted methode mit Comparator\n");
		
		Comparator<Integer> cmp = (i1, i2) -> Integer.compare(i2, i1);
		
		Arrays.stream(array)
			.sorted(cmp)
			.forEach(s -> System.out.println(s));
		
		Comparator<Blume> cmp2 = Comparator.comparing(Blume::getPreis);
		Comparator<Blume> cmp3 = Comparator.comparing(Blume::getName);
		
		Stream.of(new Blume(2,"a"), new Blume(1,"x"), new Blume(1,"a"))
			.sorted(cmp2.thenComparing(cmp3))
			.forEach(s -> System.out.println(s));
		

	}
	
	static class Blume {
		int preis;
		String name;

		public Blume(int preis,String name) {
			super();
			this.preis = preis;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Blume [preis=" + preis + "] " + name ;
		}

		public int getPreis() {
			return preis;
		}
		
		public String getName() {
			return name;
		}
		
		
		
	}

}

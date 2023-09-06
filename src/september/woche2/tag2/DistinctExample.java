package september.woche2.tag2;

import java.util.Objects;
import java.util.stream.Stream;

public class DistinctExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *  Stream<T> distinct();
		 */
		
		
		Stream.of(1,2,3,1,4,6,2,1,3)
			.distinct()
			.forEach(a -> System.out.println(a));
		
		
		
		Stream.of(new Blume(90), new Blume(90), new Blume(90))
			.distinct()
			.forEach(s -> System.out.println(s));
		

	}
	
	
	static class Blume {
		int preis;

		@Override
		public int hashCode() {
			return Objects.hash(preis);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Blume other = (Blume) obj;
			return preis == other.preis;
		}

		public Blume(int preis) {
			this.preis = preis;
		}

		@Override
		public String toString() {
			return "Blume [preis=" + preis + "]";
		}

	}

}

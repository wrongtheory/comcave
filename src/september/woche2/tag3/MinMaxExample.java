package september.woche2.tag3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;

public class MinMaxExample {

	public static void main(String[] args) {
		
		
		Integer[] arr = {7,33,5,-5,11,1};
		
		/*
		 *  Optional<T> max(Comparator<? super T> comparator);
		 *  public interface Comparator<T> 
		 *  int compare(T o1, T o2);
		 */
		
		Comparator<Integer> cmp = Comparator.naturalOrder();
		
		Optional<Integer> maybeMax = Arrays.stream(arr)
			.max(cmp);
		
		System.out.println(maybeMax.get());
		
		Integer min = Arrays.stream(arr)
				.min(cmp)
				.get();
		
		System.out.println(min);
		
		class MyConsumer implements Consumer<Integer> {
			Optional<Integer> maybeMax = Optional.empty();
			public void accept(Integer x) {
				if(!maybeMax.isPresent()) {
					maybeMax = Optional.of(x);
				} else {
					int max = maybeMax.get();
					if(x > max)
						maybeMax = Optional.of(x);
				}
			}
 		}
		
		MyConsumer c = new MyConsumer();
		Arrays.stream(arr).forEach(c);
		int max = c.maybeMax.get();
		System.out.println(max);

	}

}

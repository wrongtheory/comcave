package september.woche3.tag3;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamBilden {

	public static void main(String[] args) {

		
		double[] arr = {0.1,1.2,2.3,3.4,4.5,5.6};
		
		Arrays.stream(arr).forEach(s -> System.out.println(s));
		
		long cnt = IntStream.range(7, 11)
				.filter(x->x!=8)
				.count();
		
		System.out.println(cnt);
		
		
	}

}

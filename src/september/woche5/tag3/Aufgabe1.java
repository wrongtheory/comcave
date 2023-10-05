package september.woche5.tag3;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Aufgabe1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		//a1();
		//System.out.println();
		//a1_1();
		//a1_2();
		
		//a1_3();
		a2();
		int sum = a3();
		System.out.println("sum: " + sum);
		
		
	}
	
	static void a1() {
		
		Runnable target = () -> {
			
			new Random().doubles(10,1,9)
			.forEach(x -> System.out.print(String.format("%.02f", x)));
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(target);
		service.shutdown();
		
	}
	
	
	static void a1_1() {
		
		Runnable target = () -> {
			
			DoubleStream.generate(Math::random)
			.limit(10)
			.forEach(x -> System.out.println(String.format("%.2f", x*100)));
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(target);
		service.shutdown();
		
	}
	
	static void a1_2() {
		
		Runnable target = () -> {
			
			DoubleStream.generate(new Random()::nextDouble)
			.limit(10)
			.forEach(x -> System.out.println(String.format("%.2f", x*10)));
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(target);
		service.shutdown();
		
	}
	
	static void a1_3() {
		
		Runnable target = () -> {
			
			DoubleStream.generate(ThreadLocalRandom.current()::nextDouble)
			.limit(10)
			.forEach(x -> System.out.print(String.format("%.2f", x*10) + ", "));
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(target);
		service.shutdown();
		
	}
	
	static void a2() throws InterruptedException, ExecutionException {
		
		Callable<Double> callable = () -> {
			return new Random().doubles(10,1,9)
					.peek(x -> System.out.print(String.format("%.2f", x) + ", "))
					.map(x -> Double.valueOf(String.format("%.2f", x))).sum();
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<Double> future = service.submit(callable);
		
		service.shutdown();
		
		Double sum = future.get();
		
		System.out.println("Sum: " + sum);
	}
	
	static int a3() throws InterruptedException, ExecutionException {
		int sum = 0;
		Callable<Integer> target = () -> {
			return Stream.generate(Random::new)
					.map(x -> x.nextInt(10))
					.peek(x -> System.out.print(x + " "))
					.findFirst().get();
		};
	
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++) {
			Future<Integer> future = service.submit(target);
			sum += future.get();
		}
		service.shutdown();
		
		
		return sum;
	}

}

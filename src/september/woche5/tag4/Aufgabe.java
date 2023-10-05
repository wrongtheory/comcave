package september.woche5.tag4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import words.*;

public class Aufgabe {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("************************A2**********************************");
		//a2();
		System.out.println("************************A3**********************************");
		//a3();
		System.out.println("************************A5***********************************");
		a5();
		System.out.println("************************A5***********************************");
		a6();



	}
	
	static void a2() throws InterruptedException {	
		
		List<String> en = Words.englishWords();
		List<String> de = Words.germanWords();
		List<String> pass= Words.passwords();

		List<String> list = Words.englishWords();
		List<String> list2 = Words.germanWords();
		List<String> list3 = Words.passwords();
		
		Runnable task = () -> {
			long count = list.stream()
					.filter(x -> x.contains("t"))
					.count();
			System.out.println("English Words that contains the letter 't': " + count);
		};
		
		Runnable task2 = () -> {
			long count = list2.stream()
					.filter(x -> x.contains("t"))
					.count();
			System.out.println("German Words that contains the letter 't': " + count);
		};

		Runnable task3 = () -> {
			long count = list3.stream()
					.filter(x -> x.contains("t"))
					.count();
			System.out.println("Passwords that contains the letter 't': " + count);
		};


		ExecutorService service = Executors.newFixedThreadPool(3);	
		
		service.execute(task);	
		service.execute(task2);
		service.execute(task3);
		
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.SECONDS);
		
		long count1 = en.stream()
				.filter(x -> x.contains("t"))
				.count();
		
		long count2 = de.stream()
				.filter(x -> x.contains("t"))
				.count();

		
		long count3 = pass.stream()
				.filter(x -> x.contains("t"))
				.count();
		
		System.out.println("en('t'): " + count1 + "\n" + "de('t'): " + count2 + "\n" + "pass('t'): " + count3);


	}
	
	static void a3() throws InterruptedException, ExecutionException {
		
		List<String> en = Words.englishWords();
		List<String> de = Words.germanWords();
		List<String> pass= Words.passwords();

		List<String> list = Words.englishWords();
		List<String> list2 = Words.germanWords();
		List<String> list3 = Words.passwords();
		
		
		Callable<Long> callable = () -> {
			long count =  list.stream()
					.filter(x -> x.contains("oo"))
					.count();
			
			System.out.println("English Words that contains the letter 'oo': " + count);
			
			return count;
		};
		
		Callable<Long> callable2 = () -> {
			long count =  list2.stream()
					.filter(x -> x.contains("oo"))
					.count();
			System.out.println("German Words that contains the letter 't': " + count);
			return count;
		};

		Callable<Long> callable3 = () -> {
			long count =  list3.stream()
					.filter(x -> x.contains("oo"))
					.count();
			System.out.println("Passwords that contains the letter 't': " + count);
			return count;
		};

		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Collection<Callable<Long>> coll = Arrays.asList(callable,callable2,callable3);
		
		service.invokeAll(coll);
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.SECONDS);
		

		long count1 = en.stream()
				.filter(x -> x.contains("oo"))
				.count();
		
		long count2 = de.stream()
				.filter(x -> x.contains("oo"))
				.count();

		
		long count3 = pass.stream()
				.filter(x -> x.contains("oo"))
				.count();
		
		System.out.println("en('oo'): " + count1 + "\n" + "de('oo'): " + count2 + "\n" + "pass('oo'): " + count3);

		
	}
	
	static void a5() throws InterruptedException {
		
		List<String> en = Words.englishWords();
		List<String> de = Words.germanWords();
		List<String> pass= Words.passwords();

		List<String> list = Words.englishWords();
		List<String> list2 = Words.germanWords();
		List<String> list3 = Words.passwords();
		
		Callable<Long> callable = () -> {
			long count =  list.stream()
					.filter(x -> x.length() == 5)
					.count();
			
			System.out.println("English Words count with the length 5: " + count);
			
			return count;
		};
		
		Callable<Long> callable2 = () -> {
			long count =  list2.stream()
					.filter(x -> x.length() == 5)
					.count();
			System.out.println("German Words count with the length 5: " + count);
			return count;
		};

		Callable<Long> callable3 = () -> {
			long count =  list3.stream()
					.filter(x -> x.length() == 5)
					.count();
			System.out.println("Passwords count with the length 5: " + count);
			return count;
		};

		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Collection<Callable<Long>> coll = Arrays.asList(callable,callable2,callable3);
		
		service.invokeAll(coll);
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.SECONDS);

		long count1 = en.stream()
				.filter(x -> x.length() == 5)
				.count();
		
		long count2 = de.stream()
				.filter(x -> x.length() == 5)
				.count();

		
		long count3 = pass.stream()
				.filter(x -> x.length() == 5)
				.count();
		
		System.out.println("en('==5'): " + count1 + "\n" + "de('==5'): " + count2 + "\n" + "pass('==5'): " + count3);

		
	}
	
	static void a6() throws InterruptedException, ExecutionException {
	
		List<String> list = Words.englishWords();

		int parts = 50;
		int partSize = list.size() / parts;
		
		System.out.println("list size: " + list.size());
		System.out.println("parts: " + parts);
		System.out.println("partSize: " + partSize);
		
		Collection<Callable<Long>> tasks = new ArrayList<>();
		
		for(int indefFrom = 0, i=0; indefFrom < list.size(); indefFrom += partSize, i++ ) {
			int indexTo = indefFrom + partSize;
			if(indexTo > list.size()) {
				indexTo = list.size();
			}
			System.out.printf("%02d. [%d .. %d] %n",i, indefFrom, indexTo);
			List<String> subList = list.subList(indefFrom, indexTo);
		 	tasks.add(new CountWordsLen5(subList));
		}
		

		System.out.println();
		System.out.println("list size: " + list.size());
		System.out.println("parts: " + parts);
		System.out.println("partSize: " + partSize);
		
		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<Long>> futures =  service.invokeAll(tasks);
		
		service.shutdown();
		
		long count = 0;
		
		for(Future<Long> f : futures) {
			count += f.get();
		}

		
		System.out.println("Anzahl der Worter der Laenge 5: " + count);
		
	}
	
	
	static class CountWordsLen5 implements Callable<Long> {

		private List<String> words;
		
		public CountWordsLen5(List<String> words) {
			this.words = words;
		}

		@Override
		public Long call() throws Exception {

			return words.stream().filter(s -> s.length() == 5).count();
		}
		
	}

	
}

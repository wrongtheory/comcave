package september.woche3.tag1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabeCollect2 {

	public static void main(String[] args) {
		
		 List<Product> warenkorb = new ArrayList<>();
		    warenkorb.add(new Product("Brot", 129));
		    warenkorb.add(new Product("Wurst", 230));
		    warenkorb.add(new Product("Milch", 99));
		    warenkorb.add(new Product("Milch", 99));

		    gesamtpreis(warenkorb);
		    gesamtpreis2(warenkorb);
		    gesamtpreis3(warenkorb);
		    gesamtpreis4(warenkorb);
		    gesamtpreis5(warenkorb);
		    
		 List<Bestellung> bestellungen = new ArrayList<>();
		    bestellungen.add(new Bestellung("Brot", 3));
		    bestellungen.add(new Bestellung("Wurst", 1));
		    bestellungen.add(new Bestellung("Milch", 2));
		    
		    List<Product> warenkorb2 =  buildWarenkorb1(bestellungen);
		    
		   // System.out.print(warenkorb2);
		    
		   // buildWarenkorb1(bestellungen);
		    //buildWarenkorb2(bestellungen);
		    
		    buildWarenkorb3(bestellungen);

	}
	
	static List<Product> buildWarenkorb1(List<Bestellung> bestellungs) {
		    
	BiConsumer<List<Product>, Bestellung> acc = (a,b) -> {
		int price = new Random().nextInt(100,300);
		for(int i=0;i<b.getAnzahl();i++)
			a.add(new Product(b.getProductName(), price));
	};
	
	List<Product> lis1 =  bestellungs.stream()
		.parallel()
		.collect(ArrayList::new, acc, List::addAll);
	
	for(Product p : lis1)
	System.out.println(p);
	
		return lis1;
	}
	
	static List<Product> buildWarenkorb2(List<Bestellung> bestellungs) {
	    
	BiConsumer<List<Product>, Bestellung> acc = (a,b) -> {
		for(int i=0;i<b.getAnzahl();i++)
			a.add(new Product(b.getProductName(), new Random().nextInt(100,300)));
	};
	
	List<Object> lis1 =  bestellungs.stream()
		.collect(Collectors.mapping(x -> new Product(x.getProductName(), new Random().nextInt(100,300)), Collectors.toList()));
	
//	for(Product p : lis1)
//	System.out.println(p);
	
	for(Object p : lis1)
	System.out.println(p);

	
		return null;
	}
	
	static <A> List<Product> buildWarenkorb3(List<Bestellung> bestellungs) {
	    
	BiConsumer<List<Product>, Bestellung> acc = (a,b) -> {
		for(int i=0;i<b.getAnzahl();i++)
			a.add(new Product(b.getProductName(), new Random().nextInt(100,300)));
	};
	
	//List<Object> lis1 =  bestellungs.stream().forEach(s -> System.out.println(s));
//	for(Product p : lis1)
//	System.out.println(p);
	
//	for(Object p : lis1)
//	System.out.println(p);

	Collector<Bestellung, List<Product>, List<Product>>  coll = new Collector<Bestellung, List<Product>,List<Product>>() {

		@Override
		public Supplier<List<Product>> supplier() {
			// TODO Auto-generated method stub
			return new Supplier<List<Product>>() {
				
				@Override
				public List<Product> get() {
					// TODO Auto-generated method stub
					return new ArrayList<Product>();
				}
			};
		}

		@Override
		public BiConsumer<List<Product>, Bestellung> accumulator() {
			// TODO Auto-generated method stub
			return new BiConsumer<List<Product>, Bestellung>() {
				
				@Override
				public void accept(List<Product> t, Bestellung u) {
					int price = new Random().nextInt(100,300);
					for(int i=0;i<u.getAnzahl();i++)
						t.add(new Product(u.getProductName(), price));

					
				}
			};
		}

		@Override
		public BinaryOperator<List<Product>> combiner() {
			// TODO Auto-generated method stub
			return new BinaryOperator<List<Product>>() {
				
				@Override
				public List<Product> apply(List<Product> t, List<Product> u) {
					// TODO Auto-generated method stub
					return t;
				}
			};
		}

		@Override
		public Function<List<Product>, List<Product>> finisher() {
			// TODO Auto-generated method stub
			return new Function<List<Product>, List<Product>>() {
				
				@Override
				public List<Product> apply(List<Product> t) {
					// TODO Auto-generated method stub
					return t;
				}
			};
		}

		@Override
		public Set<Characteristics> characteristics() {
			// TODO Auto-generated method stub
			return new TreeSet<Collector.Characteristics>();
		}
	};
	
	List<Product> l =  bestellungs.stream()
		.collect(coll);
	
	for(Product p : l)
		System.out.println(p);
	
		return null;
	}
	
	
	static void gesamtpreis(List<Product> products) {
		
	int sum = 	products.stream()
			.flatMap(x -> Stream.of(x.getPreis()))
			.collect(Collectors.summingInt(x -> x));
	System.out.println(sum);

	}
	
	static void gesamtpreis2(List<Product> products) {
		
	long sum = 	products.stream()
			.flatMap(x -> Stream.of(x.getPreis()))
			.collect(Collectors.summarizingInt(x -> x)).getSum();
	System.out.println(sum);

	}
	
	static void gesamtpreis3(List<Product> products) {
		
		Function<List<Integer>, Integer> func = x -> {
			int sum = 0;
			for(Integer i : x)
				sum+=i;
			return sum;
		};
		
	Object sum = products.stream()
			.flatMap(x -> Stream.of(x.getPreis()))
			.collect(Collectors.collectingAndThen(Collectors.toList(),func));
	
	System.out.println(sum);

	}
	
	static void gesamtpreis4(List<Product> products) {
		
	long sum = 	products.stream()
			.collect(Collectors.flatMapping(a -> Stream.of(a), Collectors.summingInt(x ->x.getPreis())));
	
	System.out.println(sum);

	}
	
	static void gesamtpreis5(List<Product> products) {
		
	long sum = 	products.stream()
			.collect(Collectors.reducing(0, x -> x.getPreis() , (a,b) -> a+b));
	
	System.out.println(sum);

	}



}

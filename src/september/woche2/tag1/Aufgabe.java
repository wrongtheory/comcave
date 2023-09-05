package september.woche2.tag1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class Aufgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***A1***********************************");
		
		System.out.println("\nOriginal list\n");
		
		 List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		 List<Integer> list2 = Arrays.asList( 55, 77 );

		    // A
		    List<List<Integer>> list3 = Arrays.asList(list1, list2);
		    for(List<Integer> e : list3) {
		        System.out.println("size = " + e.size() + ". elements = " + e);
		    }
		    // B
		    
		    System.out.println("");
		    
		    List<List<Integer>> list4 = Arrays.asList(list1, list2);

		    System.out.println("\nmit foreach\n");
		    
		    list4.stream()
		    	.forEach(s->System.out.println("size = " + s.size() + ". elements = " + " " + s ));
		    
		    
		    System.out.println("\nmit map\n");
		    
		    list4.stream()
		    	.map(x -> "size = " + x.size() + ". elements = " + " " + x)
		    	.forEach(a -> System.out.println(a));
		    
		    System.out.println("\nmit concat und map\n");
		    
		    Stream.concat(Stream.of(list1), Stream.of(list2))
	    		.map(x -> "size = " + x.size() + ". elements = " + " " + x)
	    		.forEach(a -> System.out.println(a));
		    
		    
		    System.out.println("\nmit concat und foreach\n");
		    Stream.concat(Stream.of(list1), Stream.of(list2))
		    	.forEach(s->System.out.println("size = " + s.size() + ". elements = " + " " + s ));
		    
		    System.out.println("\nmit foreach\n");
		    Stream.of(list1, list2)
		    	.forEach(e ->  System.out.println("size = " + e.size() + ". elements = " + e));
		    
		    
//		    Stream.of(list1,list2)
//		    	.flatMap(x -> x.stream())
//		    	//.map(x -> "size = " + x.size() + ". elements = " + " " + x);
//		    	.forEach(a -> System.out.println(a));

		    
		    System.out.println("\n***A2****************************************\n");
		    
		    
//	        for (int i = 1; i < 100; i++) {
//	            System.out.println( Test.nextInt() );
//	        }
 
	        Stream.generate(() -> new Random().nextInt(1,6))
	        	.limit(5)
	        	.forEach(x -> System.out.println(x));
	        
	        Stream.generate(() -> new Random().nextInt(1,Integer.MAX_VALUE))
	        	.limit(5)
	        	.forEach(s->System.out.println(s));
	        
	        
	        System.out.println("\n***A3*********************************************\n");
	        
//	        for (int i = 100; i >= 1; i--) {
//	            System.out.println( i );
//	        }

	        
	        Stream.iterate(100, x -> --x)
	        	.limit(10)
	        	.forEach(x -> System.out.println(x));
	        
	        System.out.println("\n***A4************************************************\n");
	        
	        String[] a1 = { "a", "b" };
	        String[] a2 = { "c", "d" };

//	        // A
//	        String[][] a3 = { a1, a2 };
//	        for (String[] arr : a3) {
//	            for (String s : arr) {
//	                System.out.println(s);
//	            }
//	        }
//	        // B
	        
	        
	        System.out.println("\nmit concat\n");
	        Stream.concat(Arrays.stream(a1), Arrays.stream(a2))
	        	.forEach(s -> System.out.println(s));
	        
	        
	        System.out.println("\nmit flatMap\n");
	        Stream.of(a1,a2)
	        	.flatMap(x -> Arrays.stream(x))
	        	.forEach(s -> System.out.println(s));
	        
	        
	        
	        System.out.println("\nmit Arrays.stream\n");
	        String[][] a3 = { a1, a2 };
	        Arrays.stream(a3)
	        	.flatMap(x -> Arrays.stream(x))
	        	.forEach(x -> System.out.println(x));
	        
	        Stream<String> s1 = Arrays.stream(a1);
	        Stream<String> s2 = Arrays.stream(a2);
	        
	        Stream.concat(s1, s2)
	        	.forEach(s -> System.out.println(s));
	        
	        
	        System.out.println("\n***A5***********************************************\n");
	        
	        //A
	        Collection<String> coll = new ArrayList<>();
	        coll.add("/a");
	        coll.add("/a/b");
	        coll.add("/a/b/c");
	        coll.add("/a/b/c/d");
//	        for(String s : coll) {
//	            System.out.println(s);
//	        }
	        // B

	        
	        
//	        String s = Arrays.stream(new String[] {"a","b","c"})
//	        		.collect(StringBuilder::new, (a,b) -> {
//	        			
//	        			
//	        		},StringBuilder::append).toString();
//	        
//	        System.out.println(s);
	        
	        
	        Stream.iterate("/a", s -> s + "/" + (char)(1 + s.charAt(s.length()-1)))
	        	.limit(4)
	        	.forEach(x->System.out.println(x));
	        


	} // main
	
	class Test {
	    static Integer nextInt() {
	        return new Random().nextInt();
	    }

}
	
} // public class

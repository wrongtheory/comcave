package september.woche2.tag2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Aufgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("***A1***************************************\n");
		System.out.println("ohne stream: \n");
		
	    List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);

	    // A
	    for(Integer x : list) {
	        if(x==15 || x==19) {
	            System.out.println("Treffer: " + x);
	        }
	    }
	    // B
	    
	    System.out.println("\nmit stream: \n");
	    
	    list.stream()
	    	.filter(x -> x ==15 || x == 19)
	    	.forEach(s -> System.out.println("Treffer: " + s));
	    
	    list.stream()
    	.filter(x -> x ==15 || x == 19)
    	.forEach(s -> System.out.println(s ==15 || s == 19 ? ("Treffer: " + s) : "" ));
    
	    
	    
	    System.out.println("\n***A2***************************************\n");
	    
	    Integer [] array = { 1, 4, 7, 3, -8 };
	    
	    System.out.println("ohne stream: \n");

	    //A
	    for (Integer x : array) {
	        System.out.println( x % 2 == 0 ? "gerade" : "ungerade" );
	    }
	    //B
	    
	    System.out.println("\nmit stream: \n");
	    
	    Stream.of(array)
	    	.forEach(s -> System.out.println(s % 2 == 0 ? "gerade" : "ungerade" ));
	    
	    Arrays.stream(array)
	    	.map(x -> x % 2 == 0 ? "gerade" : "ungerade")
	    	.forEach(s -> System.out.println(s));
	    
	    System.out.println("\n***A3***************************************\n");
	    
	    System.out.println("ohne stream: \n");
	    
	    List<String> list2 = Arrays.asList("Tom", "Jerry", "Rex");

	    //A
	    for(String name: list2) {
	        Tier t = new Tier(name);
	        System.out.println(t);
	    }
	    //B
	    
	    System.out.println("\nmit stream: \n");
	    
	    
	    list2.stream()
	    	.forEach(s -> System.out.println(new Tier(s)));
	    
	    list2.stream()
	    	.map(Tier::new)
	    	.forEach(s -> System.out.println(s));
	    
	    
	    
	    System.out.println("\n***A4***************************************\n");
	    
	    System.out.println("mit stream: \n");
	    
	    
	    Stream.generate(() -> new Random().nextInt(-20,20))
	    	.limit(10)
	    	.filter(x -> x < -15 || x > -10)
	    	.map(x -> x.doubleValue())
	    	.forEach(s->System.out.println(s));
	    
	    System.out.println("\n");
	    
	    Stream.generate(() -> new Random().nextInt(-20,20))
    		.filter(x -> x < -15 || x > -10)
    		.limit(10)
    		.map(x -> x.doubleValue())
    		.forEach(s->System.out.println(s));
	    
	    System.out.println("\n***A5***************************************\n");
	    
	    //System.out.println("ohne stream: \n");
	    
	    Tier[] array2 = {
	            new Tier("Rex"),
	            new Tier("Tom"),
	            new Tier("Jerry"),
	            new Tier("Tom"),
	            new Tier("Jerry"),
	        };
	    
	    System.out.println("\nmit stream: \n");
	    
	    Stream.of(array2)
	    	.distinct()
	    	.forEach(s -> System.out.println(s));
	    
	    
	    System.out.println("\n***A6***************************************\n");
	    
	    List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
	    List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
	    List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");


	    Stream.of(mailsErsthelfer, mailsIT, mailsQM)
        	.flatMap(x -> x.stream())
        	.map(x -> x.substring(0, x.indexOf("@")))
        	.distinct()
        	.forEach(System.out::println);
	}
	
	static class Tier {
        private String name;

        public Tier(String name) {
            this.name = name;
        }
        
        public String toString() {
            return "Tier " + name;
        }
        
        public int hashCode() {
        	return name.hashCode();
        }
        
        public boolean equals(Object obj) {
        	return ((Tier)obj).name == name;
        }
    }

}

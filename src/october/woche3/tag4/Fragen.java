package october.woche3.tag4;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

class Vehicle{
	int v;
	String n;
	public Vehicle(int v, String n) {
		super();
		this.v = v;
		this.n = n;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "Vehicle [v=" + v + ", n=" + n + "]";
	}
	
	
}


class Vehicle2 {
	int vno;
	String name;
	public Vehicle2(int vno, String name) {
		this.vno = vno;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Vehicle2 [vno=" + vno + ", name=" + name + "]";
	}
	
	
}

public class Fragen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Vehicle2> vv = new HashSet<>();
		vv.add(new Vehicle2(10123, "Ford"));
		vv.add(new Vehicle2(10124, "BMW"));
		
		System.out.println(vv);
		
//		List<String> lst = Arrays.asList("dasfds","dasfdsf");
//		System.out.println(lst.stream().filter(x -> x.length()>3).mapToInt(x -> Integer.valueOf(x)).count());
		
		double d = 15;
		Locale l = new Locale("md","MD");
		NumberFormat f = NumberFormat.getCurrencyInstance(l);
		System.out.println(f.format(d));
		
		
		
		List<Vehicle> v = Arrays.asList(new Vehicle(2, "Car"), new Vehicle(3, "Bike"), new Vehicle(1, "Truck"));
		v.stream().map(x -> x.getV()).sorted() .forEach(System.out::println);
		//Av.stream().sorted(v1,v2) -> Integer.compapre(v1.get) .forEach(System.out::println);
		
		ZoneId zone = ZoneId.of("America/New_York");
		ZonedDateTime dt = ZonedDateTime.of(LocalDate.of(2015, 3, 8), LocalTime.of(1, 0), zone);
		ZonedDateTime dt2 = dt.plusHours(2);
		System.out.println(DateTimeFormatter.ofPattern("H:mm - ").format(dt2));
		System.out.println(ChronoUnit.HOURS.between(dt, dt2));
		
		List<String> c = Arrays.asList("red0","green","yellow");
		Predicate<String> test = hz -> {
			System.out.println("Searching"); 
			return hz.contains("red");
		};
		
		
		c.stream().filter(x -> x.length() > 3).allMatch(test);
		
		Deque<String> dq = new ArrayDeque<>();
		dq.add("Susan");
		dq.add("Allen");
		dq.add("David");
		
		System.out.println(dq.pop());
		System.out.println(dq.remove());
		System.out.println(dq);
		
		Map<Integer, Integer> mVal = new HashMap<>();
		mVal.put(1, 10);
		mVal.put(2, 20);
		
		BiConsumer<Integer, Integer> cc = (i,j) -> System.out.println(i + ", " + j + ";");
		cc.accept(1, 2);
		mVal.forEach(cc);
		
		
	}

}

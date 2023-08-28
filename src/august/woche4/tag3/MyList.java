package august.woche4.tag3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList implements Iterable<String>{
	
	private static final int maxCapacity = 10;
	
	private final String[] elements = new String[maxCapacity];
	
	private int nextFreePosition = 0;
	
	public int size() {
		return nextFreePosition;
	}

	public void add(String s) {
		if(nextFreePosition >= elements.length)
			throw new IllegalStateException("List ist voll");
		elements[nextFreePosition++] = s;
		
	}
	
	public String get(int index) {
		
		if(index < 0 || index >= maxCapacity)
			throw new IllegalArgumentException("Falsche index");
		if(nextFreePosition <= index)
			throw new NoSuchElementException("Unavailaible index");
		return elements[index];
	}
	
	public static void main(String[] args) {
		
		MyList list = new MyList();
		
		System.out.println("1. size: " + list.size()); //0
		
		list.add("mo");
		list.add("di");
		
		System.out.println("2. size: " + list.size()); //2
		
		for(int i=0;i<8;i++)
			list.add("s"+i);
		
		System.out.println("3. size: " + list.size()); //10
		
		try {
			list.add("exception");
		}catch(IllegalStateException e) {
			System.out.println("Die Liste ist voll");
		}
		
		System.out.println("\nTest von get");
		
		MyList list2 = new MyList();
		try {
			list2.get(0);
		}catch(NoSuchElementException e) {
			System.out.println("Keine elemente noch");
		}
		
		for(String s : list) {}
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

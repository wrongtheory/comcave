package august.woche4.tag2;

import java.util.Iterator;

import javax.lang.model.util.Elements;

class ListIsFullException extends ArrayStoreException {}

class PositionIndexNichtBelegtException extends NullPointerException {}

class IndexKleinerGroeserException extends ArrayIndexOutOfBoundsException{}

public class MyList implements  Iterable<String> {

	private String[] elements;
	private int next = 0;

	public MyList(int capacity) {
		this.elements = new String[capacity];
	}
	
	public MyList() {
		
	}

	void add(String element) {
			
		try {
			if (next >= size())
				throw new ListIsFullException();
			elements[next++] = element;
			System.out.print("'" + element + "' was added in the Container");
			System.out.println("  ===>  " + (size() - next) + " slots are still available");
		}catch(ListIsFullException e) {
			System.out.println("List is voll");
		}
		

	}

	int size() {
		return elements.length;
		//return next;
	}

	String get(int index) {
		
		if(index < 0 || index > 9)
			throw new IndexKleinerGroeserException();
		else
		if(elements[index] == null)
			throw new PositionIndexNichtBelegtException();

	return elements[index];
	}

	public static void main(String[] args) {

		System.out.println("Maximal Container capacity: 10");

		MyList myList = new MyList(10);

		myList.add("1 Element");
		myList.add("2 Element");
		myList.add("3 Element");
//		System.out.println(myList.get(20)); // IndexKleinerGroeserException
//		System.out.println(myList.get(7));  // PositionIndexNichtBelegtException
		myList.add("4 Element");
		myList.add("5 Element");
		myList.add("6 Element");
		myList.add("7 Element");
//		System.out.println(myList.get(5)); // return 6 Element
		myList.add("8 Element");
		myList.add("9 Element");
		myList.add("10 Element");

		//try {
		 myList.add("11 Element"); // soll exception werfen
		//}catch(ListIsFullException e) {
		//	System.out.println("List is voll");
		//}
		
		Iterator<String> it = myList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Override
	public Iterator<String> iterator() {
		return new Itr();
	}

	private class Itr implements Iterator<String> {
		int cursor;       // index of next element to return

		@Override
		public boolean hasNext() {
			return cursor!=next;
		}

		@Override
		public String next() {
            //return elements[cursor++];
			return get(cursor++);
		}		
	}
}

package august.woche4.tag5.aufgaben;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BrowseHistory {

	static Deque<String> dq = new ArrayDeque<>(5);
	static Deque<String> previous;
	
	static String s = "";
	private static final int MAX = 5;
	static String current="";
	static Iterator<String> it;

	public static void main(String[] args) {

		BrowseHistory browser = new BrowseHistory();

		System.out.println("=============A2===============");
		browser.open("u1.com");
		browser.open("u2.com");
		browser.open("u3.com");
		browser.open("u4.com");
		browser.open("u5.com");
		current = dq.peekLast();

		System.out.println("\n" + browser.getCurrent());
		System.out.println("=============A3===============");

		browser.open("u6.com");
		current = dq.peekLast();
		System.out.println("\n" + browser.getCurrent());
		
		System.out.println("=============A4===============");
		
		 previous = new ArrayDeque<>();
		s = "";
		it = dq.iterator();
		browser.openPrevious();
		browser.openPrevious();
		browser.openPrevious();
		browser.openPrevious();
		System.out.println(previous);
		current = previous.peekLast();
		//System.out.println(browser.getCurrent());
	}

	private void openPrevious() {
		//s="";
		//s+=previous.pollFirst();
		previous.add(it.next());
		//System.out.println(previous);
		//System.out.print(s);
	}

	private String getCurrent() {
		return "Current: "+current;
	}

	private void open(String string) {

		if (dq.size() < MAX) {
			dq.add(string);

			System.out.println(s + "[" + dq.peekLast() + "]");
			// System.out.print(s);

			// for(Iterator<String> it = dq.iterator(); it.hasNext(); it.next()) {
			s += dq.peekLast() + " < ";
		} else {
			s = "";
			dq.pollFirst();
			dq.add(string);
			List<String> list = new ArrayList<>(dq);
			System.out.print(list.get(0));
			for (int i = 1; i < dq.size(); i++) {
				s += " < " + list.get(i);
			}
			System.out.println(s);
		}

	}

}

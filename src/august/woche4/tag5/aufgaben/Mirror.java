package august.woche4.tag5.aufgaben;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class Mirror {

	Deque<Character> dq = new ArrayDeque<>();

	private void add(char c) {
		dq.add(c);
		if (dq.size() == 1)
			dq.push('|');
		dq.push(c);

	}

	public boolean isEmpty() {
		return dq.size() < 2;
	}

	public void remove() {
		dq.pollFirst();
		dq.pollLast();

	}

	public String toString() {
		String s = "";
		for (Iterator<Character> i = dq.iterator(); i.hasNext();)
			s = s + i.next();
		return s;
	}

	public static void main(String[] args) {

		Mirror mirror = new Mirror();

		for (char ch = 'a'; ch < 'g'; ch++) {
			mirror.add(ch);
			System.out.println(mirror);

		}

		System.out.println();

		while (!mirror.isEmpty()) {
			System.out.println(mirror);
			mirror.remove();

		}

	}

}

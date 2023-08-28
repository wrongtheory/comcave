package august.woche4.tag5.aufgaben;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class Palindrom {

	public static void main(String[] args) {

		Character[] arr = { 'a', 'n', 'n', 'a' };

		boolean erg = isPalindrome(arr);
		System.out.println(erg);

		arr = new Character[] { 'r', 'o', 't', 'o', 'r' };
		erg = isPalindrome(arr);
		System.out.println(erg);

		arr = new Character[] { 'm', 'o', 't', 'o', 'r' };
		erg = isPalindrome(arr);
		System.out.println(erg);
		
		String arr2 = new String("anna");
		erg = isPalindrome(arr2);
		System.out.println(erg);
		
		arr2 = new String("rotor");
		erg = isPalindrome(arr2);
		System.out.println(erg);
		
		arr2 = new String("motor");
		erg = isPalindrome(arr2);
		System.out.println(erg);

	}

	private static boolean isPalindrome(Character[] arr) {

		Deque<Character> dq = new LinkedBlockingDeque<>();
		for (Character ch : arr)
			dq.add(ch);
		System.out.println(dq);

		for (Iterator<Character> it = dq.iterator(); it.hasNext(); it.next()) {
			//System.out.println(dq.peekFirst() + " " + dq.peekLast());
			if (dq.size() > 1)
				if (!(dq.pollFirst().equals(dq.pollLast()))) {
					return false;

				}

		}
		return true;
	}
	
	private static boolean isPalindrome(String str) {
		
//		char[] chars = str.toCharArray();
//
//	    Character[] characters = new Character[chars.length];
//	    for (int i = 0; i < chars.length; i++) 
//	        characters[i]=chars[i];
		
		Character[] charcaters = str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

		return isPalindrome(charcaters);

	}
}

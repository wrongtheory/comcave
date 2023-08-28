package august.woche4.tag5.aufgaben;

import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrom2 {

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

	}
	
	static boolean isPalindrome(Character[] chars) {
		Deque<Character> deque = new ArrayDeque<>();
		
		for(Character ch : chars) {
			deque.add(ch);
		}
		
		while(deque.size() > 1) {
			if(deque.pollFirst() != deque.pollLast()) {
				return false;
			}
		}
		
		return true;
	}

}

package august.woche1.tag1;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.Temporal;

public class RichtigUberladeneFinden {
	
	static void m() {System.out.println("no args");}
	static void m(int x) {System.out.println("int");} 
	static void m(float x) {System.out.println("float");} 
	static void m(byte...x) {System.out.println("byte");}
	static void m(Integer x) {System.out.println("Integer");} 
	static void m(Number x) {System.out.println("Number");} 
	static void m(Object x) {System.out.println("Object");} 
	static void m(Integer...x) {System.out.println("Varargs");} 
	static void m(Float...x) {System.out.println("Varargs");}
	static void m(LocalDate l) {System.out.println("Localdate");}
	static void m(Temporal p) {System.out.println("Temporal");}
	static void m(ChronoLocalDate cld) {System.out.println("Chrono");}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer d = null;
		m(d);
		
		
		/*
		 * char r = 65535; int a = 33; // long <- int
		 * 
		 * m(a);
		 * 
		 * 
		 * Long b; byte c = (byte)500; //byte d = -128;
		 * 
		 * System.out.println();
		 * 
		 * 
		 * System.out.println(c);
		 * 
		 * long x1 = 12; int x2 = 12; x1 = x2; x2 = (int)x1; System.out.println(x2);
		 * 
		 * byte b1 = (byte)x2; System.out.println(b1); byte b2 = (byte)200;
		 * 
		 * System.out.println(b2);
		 * 
		 * int c1 = 1; byte c2 = (byte)c1 ; System.out.println(c2);
		 */

	}

}

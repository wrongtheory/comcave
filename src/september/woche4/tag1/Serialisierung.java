package september.woche4.tag1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UncheckedIOException;

public class Serialisierung {

	/*
	 *  1. Primitive sind serialisierbar
	 *  2. Arrays sind serialisierbar(wenn ihre Werte serialisierbar sind)
	 *  3. Objekte sind serialisierbar wenn Ihre Klasse Serializable ist
	 */
	
	static class Auto implements Serializable{
		String hersteller;
		int baujahr;

		@Override
		public String toString() {
			return hersteller + " " + baujahr;
		}	
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName = "auto1.bin";
		
		
		Auto a1 = new Auto();
		a1.hersteller = "VW";
		a1.baujahr = 2003;
		
		
		
		serialisieren(a1, fileName);
		System.out.println("Serialisiert " + a1);
		
		Auto a2 = deserialisieren(fileName);
		
		System.out.println("Deserialisiert " + a2);
	}
	
	static void serialisieren(Auto a, String fieName) throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("auto1.bin"))){
			oos.writeObject(a);
		}
	}
	
	
	static Auto deserialisieren(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			return (Auto)ois.readObject();
		}
	}
}

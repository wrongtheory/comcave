package september.woche3.tag5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AufgabeLoadSave2 {


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		int len = new Random().nextInt(100)+1;
		int[] arr1 = createArray(len, -20,20);
		
		System.out.println("1. arr1 " + Arrays.toString(arr1));
		
		saveArray(arr1, "array.txt");
		
		int[] arr2  = loadArray("array.txt");

		System.out.println("2. arr1: " + Arrays.toString(arr2));
	}
	
	private static int[] createArray(int len, int min, int max) {
		return new Random().ints(len, min, max+1).toArray();
	}

	static void saveArray(int[] array, String fileName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(array);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] loadArray(String fileName) throws ClassNotFoundException {
		try(ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(fileName))){
			return  (int[])ois.readObject();
		}catch(IOException e) {
			throw new UncheckedIOException(e);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}

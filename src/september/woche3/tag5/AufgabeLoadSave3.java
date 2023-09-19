package september.woche3.tag5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AufgabeLoadSave3 {

	public static int[] createArray(int len, int min, int max) {

		//int[] array = new int[len];
		
		return new Random().ints(len, min, max + 1).toArray();

//		for (int i = 0; i < len; i++) {
//			array[i] = new Random().nextInt(min,max);

		

		//return array;
	}

	public static void saveArray(int[] array, String fileName) {

		try (BufferedWriter out = new BufferedWriter(new FileWriter(new File(fileName)))) {

			for (int i = 0; i < array.length; i++)
				out.write(Integer.toString(array[i]) + " ");

//			out.write(Arrays.toString(array));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	




	public static int[] loadArray(String filename) {
		int[] numbers = null;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

			String line;
			String[] nums;
			while ((line = br.readLine()) != null) {
				nums = line.split(" ");
				numbers = new int[nums.length];
				for (int i = 0; i < nums.length; i++)
					numbers[i] = Integer.parseInt(nums[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return numbers;
	}
	

	public static void main(String[] args) throws IOException {

		java.io.Console console = System.console();

		int[] arr1 = null;

		while (true) {
			System.out.println("\n---------------------------------");
			System.out.print("           MENU                 -");
			System.out.print("\n---------------------------------");
			System.out.print("\n1    - createArray              -");
			System.out.print("\n2    - saveArray                -");
			System.out.println("\n3    - loadArray                -");
			System.out.println("exit - Terminate Programm       -");
			System.out.println("---------------------------------");
			String s = console.readLine("Chose an option: ");

		switch (s) {
			case "1": {
				String leng = console.readLine("Array length: ");
				arr1 = createArray(Integer.parseInt(leng), -20, 20);
				System.out.println("Array of length " + arr1.length + " was created.  \nElements: ");
				for (int i : arr1)
					System.out.print(i + " ");

			}
				break;
			case "2": {
				String save = console.readLine("Please enter the Filename: ");
				saveArray(arr1, save);
				System.out.println("array saved in the file " + save);
			}
				break;
			case "3": {
				String load = console.readLine("Filename to load from: ");
				if (!new File(load).exists()) {
					System.out.println("File doesn't exits! Try again !");
					break;
				}
				System.out.println("array loaded from file: " + load);
				int[] arr2 = loadArray(load);
				System.out.println("Elements: ");
				for (int i : arr2)
					System.out.print(i + " ");
			}
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Unknown operation!");

			}

		}
	}

}

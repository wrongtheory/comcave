package september.woche3.tag5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedClasses {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		int bufferSize = 1024;
		
		try(BufferedReader in = new BufferedReader(new FileReader(new File("autos.txt")), bufferSize);
				BufferedWriter out = new BufferedWriter(new FileWriter(new File("autos.noch.ine.kopie.txt")), bufferSize)){
			String s;
			while((s = in.readLine()) != null) {
				System.out.println(s);
				
				out.write(s);
				out.newLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}

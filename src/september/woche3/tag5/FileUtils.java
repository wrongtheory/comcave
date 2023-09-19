package september.woche3.tag5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
	
	private static void copyTextFile(String fromFile, String toFile) throws IOException {
		
		java.io.Console console  = System.console();
		
		fromFile = console.readLine("FirstFile: ");
		toFile = console.readLine("FirstFile: ");
		
		System.out.println(fromFile + " " + toFile );

		File file = new File(fromFile);
		
		if(!file.exists()) {
			//file.createNewFile();
			Files.writeString(file.toPath(), "abc\ndef\nghi");
		
		}
			
		
		try(BufferedReader br = new BufferedReader(new FileReader(file));
				BufferedWriter bf = new BufferedWriter(new FileWriter(toFile,true))){
			String s;
			
			while((s = br.readLine()) != null) {
				bf.write(s);
				bf.newLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		copyTextFile("fromFile", "toFile");

	}

}

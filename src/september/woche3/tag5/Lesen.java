package september.woche3.tag5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Lesen {

	public static void main(String[] args) {

		
		try(Reader in = new FileReader(new File("abc.txt"))){
			
			int next;
			while( (next = in.read()) != -1) {
				System.out.print((char)next);
			}
			//System.out.println("ch: " + ch);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}

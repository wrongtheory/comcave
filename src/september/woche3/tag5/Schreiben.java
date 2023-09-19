package september.woche3.tag5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Schreiben {

	public static void main(String[] args) {

		
		try(Writer out = new FileWriter(new File("abc.txt"))){
			out.write('q');
			out.write('w');
			out.write('e');
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}

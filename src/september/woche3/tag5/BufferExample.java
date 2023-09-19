package september.woche3.tag5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferExample {

	public static void main(String[] args) throws IOException {

		char[] chars = new char[30];
		
		
		Writer out = new FileWriter(new File("def"));
		
//		out.write('d');
//		out.write('e');
//		out.write('f');
		
		
		
		out.flush();
		
		//out.close();
	}

}

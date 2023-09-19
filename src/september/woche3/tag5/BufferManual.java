package september.woche3.tag5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferManual {

	public static void main(String[] args) {

		try(Reader in = new FileReader(new File("autos.txt"))){
			
			char[] cbuf = new char[6];
			
			int anzahl ;
			
			while( (anzahl =  in.read(cbuf)) != -1) {
				//System.out.println(anzahl);
				String nextChars = String.valueOf(cbuf,0,anzahl);
				System.out.print(nextChars);
			}
			//System.out.println(anzahl);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

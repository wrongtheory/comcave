package september.woche3.tag5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ManualBufferKopieren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(    Reader in = new FileReader(new File("autos.txt")); 
				Writer out = new FileWriter(new File("autos.kopie.txt"))){
			
			char[] cbuf = new char[6];
			
			int anzahl ;
			
			while( (anzahl =  in.read(cbuf)) != -1) {
				//System.out.println(anzahl);
				//String nextChars = String.valueOf(cbuf,0,anzahl);
				//System.out.print(nextChars);
				out.write(cbuf,0,anzahl);
				
			}
			//System.out.println(anzahl);
			
		}catch(IOException e) {
			e.printStackTrace();
		}


	}

}

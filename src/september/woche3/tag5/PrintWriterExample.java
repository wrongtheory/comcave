package september.woche3.tag5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try(PrintWriter out = new PrintWriter("printwriter.test")){
			
			out.println("Hallo!");
			out.print("x = ");
			out.println(22);
			out.format("y = %d%n", 77);
			
			//out.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		

	}

}

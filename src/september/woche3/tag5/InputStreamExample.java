package september.woche3.tag5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try(
		InputStream in = new FileInputStream(new File("text.txt"))){
		
		byte[] b = new byte[1024];
		int bb;
		while((bb = in.read(b)) != -1) {
			int c = bb;
			for(byte e : b)
				System.out.print((char)e);
			
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

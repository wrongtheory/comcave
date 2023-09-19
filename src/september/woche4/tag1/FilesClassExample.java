package september.woche4.tag1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesClassExample {

	public static void main(String[] args) throws IOException {

		
		Path path = Paths.get("abc.txt");
		
		boolean gefunden = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		System.out.println("File/Directory exists ? : " + gefunden);
		
		gefunden =  Files.isDirectory(path);
		System.out.println("IsDirectory ? : " + gefunden);
		
		gefunden = Files.isRegularFile(path);
		System.out.println("IsRegularFile? : " + gefunden);
		
		System.out.println("Size: " + Files.size(path)  + " byte");
		
		
		
	}

}

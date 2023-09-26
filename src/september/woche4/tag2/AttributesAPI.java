package september.woche4.tag2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class AttributesAPI {

	public static void main(String[] args) throws IOException {

		mitShortCutMethoden();
		
	}
	
	static void mitShortCutMethoden() throws IOException {
		Path file = Paths.get("autos.txt");
		
		long size = Files.size(file);
		
		boolean result =  Files.isDirectory(file);
		
		FileTime time = Files.getLastModifiedTime(file);
		
		System.out.println("size: " + size + ", isDirectory: " + result + ", time: " + time.toInstant());
		
		Object o =  Files.getAttribute(file, "");
		System.out.println(o);
		
	}

}

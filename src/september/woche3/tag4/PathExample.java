package september.woche3.tag4;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	public static void main(String[] args) {

		
		Path p1 = Paths.get("a"); // relativ
		Path p2 = Paths.get("/a"); // absoult linux
		Path p3 = Paths.get("a\\b\\c"); // relativ windows
		
		Path p4 = Paths.get("a\\b\\c\\d");
		System.out.println(p4);
		
		Path p5 = FileSystems.getDefault().getPath("/home");
		System.out.println(p5);
		
		
	}

}

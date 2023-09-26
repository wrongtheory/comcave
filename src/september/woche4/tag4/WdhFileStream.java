package september.woche4.tag4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class WdhFileStream {

	public static void main(String[] args) throws IOException {

		
		Path path = null;
		
		Stream<String> v1 =  Files.lines(path);
		List<String> v11 =  Files.readAllLines(path);
		
		
		List<String> v2 = Files.readAllLines(path);
		
		Stream<String> v3 =  Files.lines(path);
		
		List<String> v4 = Files.readAllLines(path);
		
		Stream<Path> v5 = Files.walk(path);
		
		
		
	}

}

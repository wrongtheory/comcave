package september.woche4.tag1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkAufgabe {
	
	static void printSubdirs(Path dir) throws IOException {
		Files.walk(dir,1)
			.filter(Files::isDirectory)
			.forEach(s -> System.out.println(s));
	}
	
	static void printFiles(Path dir) throws IOException {
		Files.walk(dir,1)
			.filter(Files::isRegularFile)
			.forEach(s -> System.out.println(s));
	}
	
	static void printEmptySubdirs(Path dir) throws IOException {
		Files.walk(dir)
			.filter(Files::isDirectory)
			.filter(x -> {
				try {
					return Files.list(x).count() == 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			})
			.forEach(s -> System.out.println(s));
	}
	
	static void printEmptySubdirs2(Path dir) throws IOException {
		Files.walk(dir)
			.filter(Files::isDirectory)
			.map(x -> x.toFile())
			.filter(x -> x.list().length == 0)
			.forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get(".");
		
		printSubdirs(path);
		System.out.println("---------------------------------");
		printFiles(path);
		System.out.println("---------------------------------");
		printEmptySubdirs(path);
		System.out.println("---------------------------------");
		printEmptySubdirs2(path);


	}

}

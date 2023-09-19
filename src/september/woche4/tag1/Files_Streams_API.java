package september.woche4.tag1;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Files_Streams_API {

	public static void main(String[] args) throws IOException {

		System.out.println("*********readAllLines**********************");
		Path path = Paths.get("autos.txt");
		
		// public static List<String> readAllLines(Path path) throws IOException
		
		List<String> lines = Files.readAllLines(path);
		
		lines.forEach(System.out::println);
		
		System.out.println("*********lines**********************");
		// public static Stream<String> lines(Path path) throws IOException
		
		try(Stream<String> lines2 =  Files.lines(path)){
			lines2.forEach(s -> System.out.println(s));
		}
		
		System.out.println("***********list********************");
		// public static Stream<Path> list(Path dir) throws IOException
		
		path = Paths.get(".");
		
		try(Stream<Path> list =  Files.list(path)){
			list.forEach(s -> System.out.println(s));
		}
		
		System.out.println("***********find********************");
		//public static Stream<Path> find(Path start,
        //int maxDepth,
        //BiPredicate<Path, BasicFileAttributes> matcher,
       // FileVisitOption... options)
		
		path = Paths.get(".");
		int maxDepth = 1;
		BiPredicate<Path, BasicFileAttributes> matcher = (pat, atts) -> true;
		
		try(Stream<Path> find =  Files.find(path, maxDepth, matcher)){
			find.filter(Files::isDirectory)
			
			.forEach(s -> System.out.println(s));
		}
		
		System.out.println("***********walk********************");
		
		path = Paths.get(".");
		
		
		try(Stream<Path> walky =  Files.walk(path, maxDepth)){
			walky.filter(Files::isDirectory)
			.forEach(s -> System.out.println(s));
		}
		
		
	}

}

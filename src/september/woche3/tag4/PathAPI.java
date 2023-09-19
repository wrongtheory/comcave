package september.woche3.tag4;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAPI {

	public static void main(String[] args) {

		testEquals();
		System.out.println("--------------------------------------");
		Path path = Paths.get("/home/vleunti/file.txt");
		test(path);
		
		Path path1 = Paths.get("home/vleunti/file.txt");
		test(path1);
		
		test_resolve();

	}
	
	static void test_resolve() {
		System.out.println("****resolve");
		
		Path p1 = Paths.get("C:\\MyDir");
		System.out.println("Parent: " + p1);
		
		String childName = "MySub\\MyFile";
		System.out.println("Child: " + childName);
		
		Path resultPAth =  p1.resolve(childName);
		
		System.out.println("Parent.resolve(childName): " + resultPAth);
		
		Path child = Paths.get("hallo","welt");
		System.out.println("child: " + child);
		
		resultPAth = p1.resolve(child);
		System.out.println("parent.resolve(child): " + resultPAth);
		
		p1 = Paths.get("dir");
		System.out.println("Parent: " + p1);
		
		childName = "subdir";
		System.out.println("Child: " + childName);

		resultPAth = p1.resolve(childName);
		System.out.println("parent.resolve(child): " + resultPAth);
	

		
		
	}
	
	static void test(Path path) {
		System.out.println("path: " + path);
		
		Path name =  path.getFileName();
		System.out.println("getFileName: " + name);
		
		Path parent =  path.getParent();
		System.out.println("Parent: " + parent);
		
		Path root = path.getRoot();
		System.out.println("Root: " + root);
		
	}
	
	static void testEquals() {
		System.out.println(" ***equals");
		Path p1 = Paths.get("a/b");
		Path p2 = Paths.get("c/d");
	
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		//-------------------------
		
		p1 = Paths.get("a/b");
		p2 = Paths.get("a","b");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		//-------------------------------
		
		
		p1 = Paths.get("a/b");
		p2 = Paths.get("a/./b");

		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		System.out.println("p1.equals(p2): " + p1.equals(p2));


		
	}
	
}

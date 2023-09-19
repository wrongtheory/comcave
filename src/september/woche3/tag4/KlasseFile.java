package september.woche3.tag4;

import java.io.File;

public class KlasseFile {

	public static void main(String[] args) {
		
		File file = new File("/home/vleunti");
		
		System.out.println(file.getName());
		
		File parentPath = file.getParentFile();
		
		System.out.println(parentPath);
		
		boolean exists =  parentPath.exists();
		
		System.out.println(exists);
		
		File f1 = new File("a/b/c");
		System.out.println(f1);
		
		File f2 = new File("a/b","c/d"); // parent, child 
		System.out.println(f2);
	}

}

package september.woche3.tag5;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Path parent = Paths.get(".");
		Path path = parent.resolve("mydir");
		
		System.out.println(parent.resolve(path));
		
		Path absPath = path.toAbsolutePath();
		
		System.out.println(absPath.normalize());

		

	}
	

}

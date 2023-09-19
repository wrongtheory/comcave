package september.woche3.tag4;

import java.nio.file.Paths;

public class Pfade {

	public static void main(String[] args) {

		// Absolut PAth
 		
		String p1 = "/home/vleunti/test"; // Unix
		String p2 = "C\\Windows\\Temp"; // Windows
		
		
		// Relative Path
		
		System.out.println(Paths.get(".").toAbsolutePath().normalize());
		
		String p3 = "bin\\mydir\\myfile"; // windows
		String p4 = "bin/mydir/myfile"; // Unix
		
		String p5 = "."; // actual Path
		
		String p6 = "dir/./subdir"; // redundant.Normalisiert: dir/subdir
		String p7 = ".."; // Parent
		String p8 = "/a/b/../d"; // redundant. Normalisiert: a/d
		String p9 = "dir/..subdir/./file.mit..komischen.namen.txt";
		String p10 = "/subdir/file.mit..komischen.namen.txt"; // normalisiert
		
		
	}

}

package september.woche4.tag2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesCreateDelete {

	public static void main(String[] args) throws IOException {

		Path dir = Paths.get("./subdir/newdir");
		
		//Files.createDirectory(dir);
		
		//Files.createDirectories(dir);

		//Files.createFile(dir);
		
		Files.delete(dir);
		//Files.deleteIfExists(dir);
	}

}

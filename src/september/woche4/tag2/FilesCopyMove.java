package september.woche4.tag2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyMove {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path source = Paths.get("toFile");
		Path target = Paths.get("subdir/toFile");
		
		//if(!Files.exists(target))
			//Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			
			
		Files.move(source, target);	

	}

}

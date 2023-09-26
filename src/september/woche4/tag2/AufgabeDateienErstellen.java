package september.woche4.tag2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class AufgabeDateienErstellen {
	
	static void createFiles(String rootName, String prefix, String extension, int count) throws IOException {
		
		Path path;
		String s;
		
		for(int i = 1; i <= 5; i++) {
			s = String.format(prefix + "%03d" + "." + extension, i);
			path = Paths.get(rootName, s);
			if(!Files.exists(path)) {
				Files.createFile(path);
				System.out.println("File " + s + " created") ;
			}else
				System.out.println("File " + s + " still exists");
		}
		
	}
	
	static void moveFiles(String sourceRootName, String targetRootName, String extension) throws IOException {
		
		//Path source = Paths.get(sourceRootName);
		//Path target = Paths.get(targetRootName);
		
		//Files.move(source, target);
		
	//	File[] listOfFiles = source.toFile().listFiles();
		//Path t = Files.createDirectory(target);
		
//		Stream.of(listOfFiles).forEach(file -> {
//			try {
//				Files.move(file.toPath(), t, StandardCopyOption.REPLACE_EXISTING);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		
//		for(File file : listOfFiles) {
//			if (file.isFile() && checkTxt(file)) {
//				Files.move(Paths.get(file.getPath().toString()), Paths.get(targetRootName.toString()+"\\" +file.getName()));
//				//System.out.println(file);
//			}
//		}
		
	      //final String extension2 = ".txt";
	        final File sourceDir = new File(sourceRootName);
	        final File destinationDir = new File(targetRootName);
	        //Path dir = Files.createDirectory(destinationDir.toPath());
	        File[] files = sourceDir.listFiles();
	        for(File f : files ){
	            //Path sourcePath      = Paths.get(sourceDir.getAbsolutePath() +"/"+ f.getName());
	        	//Path destinationPath = Paths.get(destinationDir.getAbsolutePath() + "/" + f.getName());
	            
	            Path sourcePath      = Paths.get(sourceDir + "/" + f.getName());
	            Path destinationPath = Paths.get(destinationDir + "/" + f.getName());

	            System.out.println("source: "+sourcePath);
	            System.out.println("dest: "+destinationPath);
	          
	            	if(!destinationDir.exists()) {
	            		Files.createDirectory(destinationDir.toPath());	
	            	}
	            	
	            	if (f.isFile() && checkTxt(f)) 
	            	Files.move(sourcePath, destinationPath,StandardCopyOption.REPLACE_EXISTING);
					//f.renameTo(new File(targetRootName+ f.getName()));
	        }        

	}

	static boolean checkTxt(File file) {
		return file.toString().endsWith(".txt");
	}
	
	static void deleteFiles(String rootName, String extension) throws IOException {
		Path files = Paths.get(rootName);
		Stream<Path> stream =  Files.list(files);
		
		stream.forEach(file -> {
			if (Files.isRegularFile(file) && checkTxt(file.toFile()))
				try {
					Files.delete(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		
//		for(File file : files) {
//			if (file.isFile() && checkTxt(file)) 
//				Files.delete(file);
//		}
}

	public static void main(String[] args) throws IOException {

		String rootName = "/home/vleunti/FileTest/Test1";
		String prefix = "file";
		String extension = "txt";
		int count = 5;
		
		//createFiles(rootName, prefix, extension, count);
		//moveFiles("/home/vleunti/FileTest/Test1/", "/home/vleunti/FileTest/Test1/newDir4/", ".txt");
		deleteFiles(rootName, extension);
	}

}

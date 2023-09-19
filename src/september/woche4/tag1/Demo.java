package september.woche4.tag1;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class FlatFilesCounterWithFile implements FilesCounter{
	
	String pathname;
	String extension;

	public FlatFilesCounterWithFile(String path, String extension) {
		this.pathname = path;
		this.extension = extension;
	}

	@Override
	public int count() throws IOException {
		File f = new File(pathname);
		long count = Arrays.stream(f.listFiles())
			.filter(s -> s.isFile())
			.map(s -> s.getName())
			.filter(s -> s.endsWith("." + extension))
			.count();
		//System.out.println(f);
		return (int)count;
	}
}

class DeepFilesCounterWithFile implements FilesCounter{
	
	String pathname;
	static String extension;


	public DeepFilesCounterWithFile(String path, String extension) {
		this.pathname = path;
		this.extension = extension;
	}
	
	static boolean checkTxt(File file) {
		System.out.println("boolean");
		return file.toString().endsWith(".txt");
	}
	
	static class Hilfe{
		static int count = 0;
		static int read(File file) {
			if(file.isFile() && checkTxt(file)) {
				//System.out.println("if" + file + " " + file.getName());
				count++;
			}
			
			else if(file.isDirectory())
			{	//System.out.println("else" + file + " " + file.getName());
				File[] listOfFiles = file.listFiles();
				if(listOfFiles != null) {
					for(File file2 : listOfFiles) {
						read(file2);
				}
			}
				
		}
		
		//System.out.println(f);
		return count;
	}
	}

	@Override
	public int count() throws IOException {
		int count = 0;
		File file = new File(pathname);
		count = Hilfe.read(file);
		return count;
	}
	
	
	public static int anotherCount(String pathname) throws IOException {
		File file = new File(pathname);
		
		long count = Files.walk(file.toPath())
			.filter(Files::isRegularFile)
			.filter(s -> s.getFileName().toString().endsWith("."+extension))
			.count();

		
		return (int)count;
	}
}
public class Demo { 
	public static void main(String[] args) throws IOException {
		FilesCounter fc = new FlatFilesCounterWithFile("/home/vleunti/FileTest", "txt");
		FilesCounter fc2 = new DeepFilesCounterWithFile("/home/vleunti/FileTest", "txt");
		
		//fc.count();
		//fc2.count();
		
		int anzahl = fc.count();
		System.out.println("Anzahl der txt_dateien: " + anzahl);
		
		//int anzahl2 = fc2.count();
		//System.out.println("Anzahl der txt_dateien: " + anzahl2);
		int x = DeepFilesCounterWithFile.anotherCount("/home/vleunti/FileTest");
		System.out.println("Anzahl der txt_dateien recursive: " + x);

	}
}

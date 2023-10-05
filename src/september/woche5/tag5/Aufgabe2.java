package september.woche5.tag5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import words.*;

class ForkJoinList extends RecursiveAction {
	
	List<String> list;
	static List<String> newList = Collections.synchronizedList(new ArrayList<>());
	private int indexFrom, indexTo;
	private static final int THRESHOLD = 10000;

	public ForkJoinList(List<String> list, int indexFrom, int indexTo) {
		this.list = list;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	protected void compute() {

		if((indexTo - indexFrom) < THRESHOLD) {
			System.out.printf("compute: %d .. %d %n",indexFrom,indexTo);
			for(int i = indexFrom; i < indexTo; i++) {
					newList.add(list.get(i));
				}
		}
		else {
			System.out.printf("zu kompliziert [%d .. %d] %n", indexFrom, indexTo);
			int middle = (indexFrom + indexTo) / 2;
			
			RecursiveAction leftAction = new ForkJoinList(list, indexFrom, middle);
			RecursiveAction rightAction = new ForkJoinList(list, middle, indexTo);
			
			invokeAll(leftAction, rightAction);
		}
	}
}

public class Aufgabe2 {
	
	public static void writeFile(List<String> data, File destination) throws IOException{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
			for(String s: data) {
				writer.write(s.toUpperCase());
				writer.newLine();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		
		List<String> list = Words.englishWords();
		
		//List<String> list = Arrays.asList("aa","bb","cc","dd");
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(new ForkJoinList(list,0,list.size()));
		
		File file = new File("test");
		
		Collections.sort(ForkJoinList.newList);
		
		writeFile(ForkJoinList.newList, file);

		System.out.println(list.size());
		System.out.println(ForkJoinList.newList.size());
	}

}

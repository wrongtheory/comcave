package august.woche4.tag5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MapImEinsatz {
	
	enum GruppenID {
		NULLEN,NEGATIVE,POSITIVE;
	}

	static GruppenID getGruppenID(int x) {
		if(x > 0) {
			return GruppenID.POSITIVE;
		} else if(x < 0) {
			return GruppenID.NEGATIVE;
		} else {
			return GruppenID.NULLEN;
		}
	}
	
	static void printCointResult(Map<GruppenID, Integer> mapCounts) {
		System.out.println("negative: " + mapCounts.get("negative"));
		System.out.println("positive: " + mapCounts.get("positive"));
		System.out.println("null: " + mapCounts.get("null"));
		
	}
	
	static void printGroupResult(Map<GruppenID, List<Integer>> mapCounts) {
		System.out.println("negative: " + mapCounts.get("negative"));
		System.out.println("positive: " + mapCounts.get("positive"));
		System.out.println("null: " + mapCounts.get("null"));
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> zahlen = new ArrayList<>();
		
		Random rnd = new Random();
		
		for (int i=0;i<100;i++) {
			int x = rnd.nextInt(201) - 100;
			zahlen.add(x);
			
		}
		
		Map<GruppenID, Integer> mapCounts = new HashMap<>();
		
		for(Integer x : zahlen) {
			GruppenID key = getGruppenID(x);
			
			Integer count = mapCounts.get(key);
			if(count==null) {
				count = 0;
			}
			mapCounts.put(key, ++count);
		}
		
		printCointResult(mapCounts);
	//---------------------------------------------------------------

		Map<GruppenID, List<Integer>> mapGroups = new HashMap<>();
		
		
		for(Integer x : zahlen) {
			GruppenID key = getGruppenID(x);
			
			List<Integer> group = mapGroups.get(key);
			
			if(group == null) {
				group = new ArrayList<>();
				mapGroups.put(key, group);
			}
			group.add(x);
		}
		

		printGroupResult(mapGroups);
		
		
	}

}

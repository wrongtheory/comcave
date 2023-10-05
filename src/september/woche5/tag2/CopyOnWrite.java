package september.woche5.tag2;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {

	public static void main(String[] args) {
		
		TestUtils.testRaceCondition(new CopyOnWriteArrayList<>());
		
		

	}

}

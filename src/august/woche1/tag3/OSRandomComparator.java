package august.woche1.tag3;

import java.util.Comparator;
import java.util.Random;

public class OSRandomComparator implements Comparator<OS>{

	@Override
	public int compare(OS o1, OS o2) {
		// TODO Auto-generated method stub
		return new Random().nextInt();
	}

}

package xyyj.chapter11;

import java.util.Comparator;

public class MonkeyComparator implements Comparator<Monkey> {

	public int compare(Monkey o1, Monkey o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {
			return -1;
		}
		
		if (o1.getName().compareTo(o2.getName()) < 0) {
			return 1;
		}
		
		return 0;
	}

}

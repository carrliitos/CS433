import java.util.Iterator;
import java.util.TreeSet;

public class SubsetSum {
	public static boolean isSumPossible(final int elements[], int numElements, int target) {
		TreeSet<Integer> sums = new TreeSet<Integer>();
		sums.add(0);
		for(int i = 0; i < numElements; i++) {
			int[] values = new int[sums.size()];
			Iterator<Integer> it = sums.iterator();
			int count = 0;
			while(it.hasNext()) {
				values[count] = it.next();
				count++;
			}
			for(int j = 0; j < values.length; j++) {
				int val = elements[i] + values[j];
				if(val == target) return true;
				else if(val < target) sums.add(val);
			}
		}
		return false;
	}
}

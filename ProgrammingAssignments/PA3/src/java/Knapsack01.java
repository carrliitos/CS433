// @ Abraham
import java.util.Arrays;

public class Knapsack01 {
	public static int findOptimalProfit(final int profits[], final int weights[], int numElements, int capacity) {
		int currentRow[] = new int[capacity + 1];
		int prevRow[] = new int[capacity + 1];

		Arrays.fill(prevRow, 0);		
		// for(int i = 0; i <= prevRow.length; i++) {
		// 	prevRow[i] = 0;
		// }
		
		for(int i = 0; i < numElements; i++) {
			if (weights[i] > capacity) {
				continue;
			}
			int j = 0;
			
			for(; j < weights[i]; j++) currentRow[j] = prevRow[j];

			for(j = weights[i]; j <= capacity; j++) {
				currentRow[j] = Math.max(prevRow[j], prevRow[j - weights[i]] + profits[i]);
			}
			prevRow = Arrays.copyOf(currentRow, currentRow.length);
			// for(int x = 0; x < prevRow.length; x++) {
			// 	prevRow[x] = currentRow[x];
			// }
		}
		return currentRow[capacity];
	}
}

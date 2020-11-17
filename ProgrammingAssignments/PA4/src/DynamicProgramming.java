import java.util.ArrayList;

public class DynamicProgramming {

	public static int numberOfBinaryStringsWithNoConsecutiveOnes(int n) { // complete this method
	}

	public static ArrayList<Integer> longestIncreasingSubsequence(int[] arr, int len) {
		int lis[] = new int[len];
		int pred[] = new int[len];
		for(int i = 0; i < len; i++) {
			lis[i] = 1;
			// pred[i] = -1;
			pred[i] = i;
		}

		/*
		* Among the indexes 0, 1, 2, . . . , i − 1, find the index maxIndex such 
		* that arr[maxIndex] < arr[i] and LIS[maxIndex] is the maximum of all 
		* the values among LIS[0], LIS[1], . . . , LIS[i − 1]. 
		* If the values arr[0], arr[1], . . . , arr[i − 1] are all greater 
		* than arr[i], then let maxIndex = −1
		*/
	}

	private static void reverse(ArrayList<Integer> list) {
		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			int temp = list.get(j);
			list.set(j, list.get(i));
			list.set(i, temp);
		}
	}
}

import java.util.*;
public class maxSumFlip {
	public static int maxSumFlip(int N[], int k) {
		// find the total sum of array
		int total_sum = 0;
		for(int i = 0; i < k; i++) {
			total_sum += N[i];
		}

		// using Kadane's algorithm
		int maxHere = -N[0] - N[0];
		int currentSum = -N[0] - N[0];
		for(int i = 1; i < k; i++) {
			// Either extend previous sub_array or start new subarray
			currentSum = Math.max(currentSum + (-N[i] - N[i]),
									(-N[i] - N[i]));

			// Keep track of max_sum array
			maxHere = Math.max(maxHere, currentSum);
		}

		// Add the sum to the total_sum
		int max_sum = total_sum + maxHere;

		// Check max_sum was maximum with or without flip
		max_sum = Math.max(max_sum, total_sum);

		// return max_sum
		return max_sum;
	}

	public static void main(String args[]) {
		int arr[] = {-2, 3, -1, -4, -2};
		int k = arr.length;

		System.out.println(maxSumFlip(arr, k));
	}
}
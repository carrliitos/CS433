import java.util.ArrayList;

public class DynamicProgramming {

	public static int numberOfBinaryStringsWithNoConsecutiveOnes(int n) {
		int B[] = new int[n]; 
		B[1] = 2;
		B[2] = 3; 

		for(int i = 2; i < n; i++){ 
			B[i] = B[i - 1] + B[i - 2]; 
		}

		return B[n-1] + B[n-2]; 
	}

	public static ArrayList<Integer> longestIncreasingSubsequence(int[] arr, int len) {
		int lis[] = new int[len];
		int pred[] = new int[len];
		int maxIndex = 0;
		
		/*
		* Among the indexes 0, 1, 2, . . . , i − 1, find the index maxIndex such 
		* that arr[maxIndex] < arr[i] and LIS[maxIndex] is the maximum of all 
		* the values among LIS[0], LIS[1], . . . , LIS[i − 1]. 
		* If the values arr[0], arr[1], . . . , arr[i − 1] are all greater 
		* than arr[i], then let maxIndex = −1
		*/
		for(int i = 0; i < len; i++) {
			lis[i] = 1;
			pred[i] = -1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[maxIndex] && lis[maxIndex] > lis[i]) { 
					maxIndex = i;
				}
				if(arr[i + 1] > arr[i]) { maxIndex = -1; }
				if(maxIndex != -1) {
					lis[i] = lis[maxIndex] + 1;
					pred[i] = maxIndex;
				}
			}
		}

		int lisIndex = 0;
		for(int i = 0; i < len; i++) {
			if(lis[i] > lis[maxIndex]) { 
				maxIndex = i; 
				lisIndex = maxIndex;
			}
		}

		ArrayList<Integer> dynamicArray = new ArrayList<>();

		dynamicArray.add(arr[lisIndex]);
		int temp = pred[lisIndex];
		while(lisIndex != temp) {
			lisIndex = temp;
			dynamicArray.add(arr[lisIndex]);
			temp = pred[lisIndex];
		}

		reverse(dynamicArray);
		return dynamicArray;
	}

	private static void reverse(ArrayList<Integer> list) {
		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			int temp = list.get(j);
			list.set(j, list.get(i));
			list.set(i, temp);
		}
	}
}

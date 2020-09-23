public class RadixSort {

	private final int[] array;
	private final int n;

	public RadixSort(int array[], int length) {
		this.array = array;
		this.n = length;
	}

	private static void countSortOnDigits(int A[], int n, int digits[]) {
		int C[] = new int[10];
		for(int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		int T[] = new int[n];
		for(int i = 0; i <= n - 1; i++) {
			C[digits[i]]++;
		}
		for(int i = 1; i <= 9; i++) {
			C[i] = C[i - 1] + C[i];
		}
		for(int i = n - 1; i >= 0; i--) {
			T[C[digits[i]] - 1] = A[i];
			C[digits[i]]--;
		}
		// Copy T to A
		for(int i = 0; i < T.length; i++) {
			A[i] = T[i];
		}
	}

	private static void radixSortNonNeg(int A[], int n) {
		// Find the max value of A[]
		int M = A[0];
		for(int i = 0; i < A.length; i++) {
			if(A[i] > M){
				M = A[i];
			}
		}

		int digits[] = new int[n];
		int e = 1;
		while((M / e) > 0) {
			for(int i = 0; i <= n - 1; i++) {
				digits[i] = (A[i] / e) % 10;
			}
			countSortOnDigits(A, n, digits);
			e = e * 10;
		}
	}

	public void radixSort() {
		// find the minimum number in the array
		int minVal = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < minVal) {
				minVal = array[i];
			}
		}
		// if min is non-negative, do radix sort
		if(minVal > 0) {
			radixSortNonNeg(array, array.length);
		}else {
			int min = minVal;
			for(int i = 0; i < array.length; i++) {
				array[i] = array[i] - min;
			}
			radixSortNonNeg(array, array.length);
			for(int i = 0; i < array.length; i++) {
				array[i] = array[i] + min;
			}
		}
	}
}

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
		for(int i = 0; i < n - 1; i++) C[digits[i++]];
		for(int i = 1; i <= 9; i++) C[i] = C[i - 1] + C[i];
		for(int i = n - 1; i >= 0; i--) {
			T[C[digits[i]] - 1] = A[i];
			C[digits[i--]];
		}
		// Copy elements of T to A
		for(int i = 0; i < T.length; i++) {
			A[i] = T[i];
		}
	}

	private static void radixSortNonNeg(int A[], int n) {
		
	}

	public void radixSort() { // complete this function
	}
}

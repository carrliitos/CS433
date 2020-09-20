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
		for(int i = 0; i < n - 1; i++) {
			digits[i] = C[i];
		}
		for(int i = 1; i <= 9; i++) {
			C[i] = C[i - 1] + C[i];
		}
		for(int i = n - 1; i >= 0; i--) {
			T[C[digits[i]] - 1] = A[i];
			digits[i] = C[i];
		}
		// Copy elements of T to A
		for(int i = 0; i < T.length; i++) {
			A[i] = T[i];
		}
	}

	private static void radixSortNonNeg(int A[], int n) {
		// Find the max value of A[]
		int M = A[0];
		for(int i = 1; i < A.length; i++) {
			if(A[i] > M) M = A[i];
		}
		int digits[] = new int[n];
		int e = 1;
		while((M / e) > 0) {
			for(int i = 0; i < n - 1; i++) {
				digits[i] = (A[i] / e) % 10;
			}
			countSortOnDigits(A, n, digits);
			e = e * 10;
		}
	}

	public void radixSort() {
		// create two separate arrays - NEG[] and NONNEG[]
		int x = 0, y = 0;
		for(int i = 0; i < array.length; i++) {
			x++;
			y++;
		}
		int Neg[] = new int[x];
		int NonNeg[] = new int[y];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > 0) NonNeg[i] = array[i];
			else Neg[i] = array[i];
		}
		
		radixSortNonNeg(NonNeg, NonNeg.length);
		
		for(int i = 0; i < Neg.length; i++) {
			if(Neg[i] < 0) Neg[i] = Neg[-i];
		}
		radixSortNonNeg(Neg, Neg.length);
		for(int i = 0; i < Neg.length; i++) {
			if(Neg[i] > 0) Neg[i] = Neg[-i];
		}

		// Combine Neg[] and NonNeg[] to the original array
		for(int i = Neg.length - 1; i > Neg.length; i--) {
			array[i] = Neg[i];
		}
		for(int i = 0; i < NonNeg.length; i++) {
			array[i] = NonNeg[i];
		}
	}
}

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int array1[] = {1, 2, 3, 4, 5};
		int array2[] = {6, 7, 8, 9, 10};
		int merged[] = mergeSortedArray(array1, array2, array1.length, array2.length);
		System.out.println(Arrays.toString(merged));
		int x[] = {5, 3, 2, 1, 4, 6, 8, 9, 7, 10};
		int y[] = recursiveMergeSort(x, x[0], x[x.length - 2]);
		System.out.println(Arrays.toString(y));
	}

	public static int[] mergeSortedArray(int A[], int B[], int lenA, int lenB) {
		int lenC = lenA + lenB;
		int C[] = new int[lenC];
		int a = 0, b = 0, c = 0;
		while(a < lenA && b < lenB) {
			if(A[a] < B[b]) {
				C[c] = A[a];
				a++;
			}else {
				C[c] = B[b];
				b++;
			}
			c++;
		}
		while(a < lenA) {
			C[c] = A[a];
			a++;
			c++;
		}
		while(b < lenB) {
			C[c] = B[b];
			b++;
			c++;
		}
		return C;
	}

	public static int[] recursiveMergeSort(int array[], int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			recursiveMergeSort(array, left, mid); // left half
			recursiveMergeSort(array, mid + 1, right);
			int mergedArray[] = new int[(right - left) + 1];
			int i = left, j = mid + 1, k = 0;
			while(i <= mid && j <= right) {
				if(array[i] < array[j]) {
					mergedArray[k] = array[i];
					i++;
				}else {
					mergedArray[k] = array[j];
					j++;
				}
				k++;
			}
			while(i <= mid) {
				mergedArray[k] = array[i];
				i++;
				k++;
			}
			while(j <= right) {
				mergedArray[k] = array[j];
				j++;
				k++;
			}
			while (j <= right - left) array[i++] = mergedArray[j++];
		}
		return array;
	}
}
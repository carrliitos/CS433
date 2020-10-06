import java.util.Arrays;

public class QuickSort extends Partition {

	public QuickSort(int[] array, int n) {
		super(array, n);
	}

	public void quicksortMedianOf3() {
		quicksortMedianOf3(0, n - 1);
	}

	public void quicksortRandom() {
		quicksortRandom(0, n - 1);
	}

	public void quicksortMedian() {
		quicksortMedian(0, n - 1);
	}

	private void quicksortMedianOf3(int left, int right) {
		int difference = right - left;
		if(difference < 32) {
			InsertionSort.insertionSort(array, left, right);
			return;
		}else if(left < right) {
			int pivot = generateMedianOf3Pivot(left, right);
			int partitionIndex = partition(left, right, pivot);
			quicksortMedianOf3(left, partitionIndex - 1);
			quicksortMedianOf3(partitionIndex + 1, right);
		}
	}

	private void quicksortRandom(int left, int right) {
		int difference = right - left;
		if(difference < 32) {
			InsertionSort.insertionSort(array, left, right);
			return;
		}else if(left < right) {
			int pivot = generateRandomPivot(left, right);
			int partitionIndex = partition(left, right, pivot);
			quicksortRandom(left, partitionIndex - 1);
			quicksortRandom(partitionIndex + 1, right);
		}
	}

	private void quicksortMedian(int left, int right) {
		int difference = right - left;
		if(difference < 32) {
			InsertionSort.insertionSort(array, left, right);
			return;
		}else if(left < right) {
			int pivot = generateMedian(left, right);
			int partitionIndex = partition(left, right, pivot);
			quicksortMedian(left, partitionIndex - 1);
			quicksortMedian(partitionIndex + 1, right);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 19, 1, 12, 100, 7, 8, 4, -10, 14, -1, 97, -1009, 4210 };
		int n = arr.length;
		int temp[] = new int[n];

		for(int i = 0; i < n; i++) temp[i] = arr[i];
		new QuickSort(temp, n).quicksortRandom();
		System.out.println("QuickSorted (random) array:      " + Arrays.toString(temp));
		
		for(int i = 0; i < n; i++) temp[i] = arr[i];
		new QuickSort(temp, n).quicksortMedian();
		System.out.println("QuickSorted (median) array:      " + Arrays.toString(temp));
	}
}

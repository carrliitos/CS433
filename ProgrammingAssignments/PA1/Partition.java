import java.util.Random;

public class Partition extends InsertionSort{

	final int array[];
	final int n;

	static Random rand;

	public Partition(int[] array, int n) {
		this.array = array;
		this.n = n;
		rand = new Random(System.currentTimeMillis());
	}

	protected void swap(int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	protected int generateRandomPivot(int left, int right) {
		int pivotIndex = left + rand.nextInt(right - left + 1);
		return array[pivotIndex];
	}

	protected int generateMedianOf3Pivot(int left, int right) {
		int mid = (left + right) / 2;

		if (array[left] > array[mid])
			swap(left, mid);

		if (array[left] > array[right])
			swap(left, right);

		if (array[mid] > array[right])
			swap(mid, right);

		return array[mid];
	}

	public int partition(int left, int right, int pivot) {
		int pivotIndex = left, partitionIndex = (left - 1), temp = 0;
		for(int k = left; k <= right; k++) {
			if(array[k] == pivot) pivotIndex = k;
			if(array[k] <= pivot) partitionIndex++;
		}
		// swap
		swap(array[pivotIndex], array[partitionIndex]);

		int i = left, j = right;
		while(i < j) {
			do {
				i++;
			}while(i <= partitionIndex && array[i] <= pivot);
			do {
				j--;
			}while(j > partitionIndex && array[j] > pivot);
			if(i < j) {
				// swap
				swap(array[i], array[i]);
			}
		}
		return partitionIndex;
	}
}
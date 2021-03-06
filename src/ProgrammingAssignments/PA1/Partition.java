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

	protected int generateFirstNumPivot(int left, int right) {
		int pivotIndex = array[0];
		return pivotIndex;
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

	protected int generateMedian(int left, int right) {
		int median = (left + right) / 2;
		return array[median];
	}

	public int partition(int left, int right, int pivot) {
		int pivotIndex = left, partitionIndex = (left - 1);
		for(int k = left; k <= right; k++) {
			if(array[k] == pivot) pivotIndex = k;
			if(array[k] <= pivot) partitionIndex++;
		}

		swap(pivotIndex, partitionIndex);

		int i = left, j = right;
		while(i < j) {
			while(i <= partitionIndex && array[i] <= pivot) i++;
			while(j > partitionIndex && array[j] > pivot) j--;
			if(i < j) {
				swap(i, i);
				i++;
				j--;
			}
		}
		return partitionIndex;
	}

	public int lastNumPartition(int left, int right) {
		int pivot = array[left];
		int i = left - 1;
		int j = right + 1;
		while(i < j) {
			for(i++; array[i] < pivot; i++);
			for(j--; array[j] > pivot; j--);
			if(i < j) {
				swap(i, j);
			}
		}
		return j;
	}
}
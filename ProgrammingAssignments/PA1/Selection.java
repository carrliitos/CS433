public class Selection extends Partition {

	public Selection(int[] array, int n) {
		super(array, n);
	}

	public int select(int k) {
		return select(0, n - 1, k);
	}

	private int select(int left, int right, int k) {
		if(left == right) {
			return array[left];
		}
		int pivot = generateRandomPivot(left, right);
		int partitionIndex = partition(left, right, pivot);
		
		if(k == partitionIndex - left + 1) {
			return pivot;
		}else if(k < partitionIndex - left + 1){
			return select(left, partitionIndex - 1, k);
		}else {
			return select(partitionIndex + 1, right, k - (partitionIndex - left + 1));
		}
	}

	private static void testSelection(int array[], int n) throws Exception {
		int mergeArray[] = new int[n];
		
		for (int i = 0; i < n; i++)
			mergeArray[i] = array[i];
		new MergeSort(mergeArray, n).mergesort();
		
		int selArray[] = new int[n];
		for (int k = 1; k <= n; k++) {
			for (int j = 0; j < n; j++)
				selArray[j] = array[j];
			Selection selection = new Selection(selArray, n);
			int answer = selection.select(k);
			System.out.printf(k + "th smallest: %d", answer);
			if (answer != mergeArray[k - 1])
				System.out.print("; Selection code does not work for k = " + k);
			System.out.println();
		}
	}

	public static void main(String args[]) throws Exception {
		System.out.println("*** Correctness Test ***\n");
		int sorting[] = { -400, -1100, -450, -500, -620, -800, -640, -400, -8, 11, 10, -80, 12, -40, 16, -4 };
		int n = sorting.length;
		int selection[] = new int[n];
		for (int i = 0; i < n; i++)
			selection[i] = sorting[i];
		
		testSelection(selection, n);
	}	
}
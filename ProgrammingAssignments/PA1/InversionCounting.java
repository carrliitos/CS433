public class InversionCounting {

	private final int mergedArray[];
	private final int array[];
	private final int n;

	public InversionCounting(int[] array, int n) {
		this.array = array;
		this.mergedArray = new int[n];
		this.n = n;
	}

	public int bruteForce() {
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (array[i] > array[j])
					count++;
		return count;
	}

	public int countInversions() {
		return countInversions(0, n - 1);
	}

	// private void mergesort(int left, int right) {
	// 	if(left == right) {
	// 		return 0;
	// 	}

	// 	int mid = (left + ((right - left) >> 1));
	// 	int inversionCount = 0;

	// 	inversionCount += mergesort(left, mid);
	// 	inversionCount += mergesort(mid + 1, right);
	// 	inversionCount += countInversions(left, right);

	// 	return inversionCount;
	// }

	private int countInversions(int left, int right) { // complete this function
        /* Brute-force algo */
        int count = 0;
        for (int i = 0; i <= n - 2; i++)
            for (int j = i + 1; j <= n - 1; j++)
                if (array[i] > array[j])
                    count++;
        return count;

        /* Failed Merge-sort approach*/
		// int count = 0;
		// int mid = (left + right) / 2;
		// int i = left, j = mid + 1, k = left;
		// if(array.length == 1) {
		// 	return 0;
		// }
		// while(left <= i && i <= j && j <= mid && array[i] >= array[j]) {
		// 	countInversions(left, mid);
		// 	mergedArray[k++] = array[i++];
		// 	count++;
		// }
		// while(mid <= i && i <= j && j <= right && array[i] >= array[j]) {
		// 	countInversions(mid + 1, right);
		// 	mergedArray[k++] = array[j++];
		// 	count++;
		// }
		// i = left;
		// while(i <= mid && j >= mid && array[i] >= array[j]) {
		// 	array[i] = mergedArray[i];
		// 	i++;
		// 	count++;
		// }
		// return count;

        // int k = left, i = left, j = mid + 1;
        // int inversionCount = 0;
        // while(i <= mid && j <= right) {
        // 	if(array[i] <= array[j]) {
        // 		mergedArray[k++] = array[i++];
        // 	}else {
        // 		mergedArray[k++] = array[j++];
        // 		inversionCount += (mid - i + 1);
        // 	}
        // }

        // while(i <= mid) {
        // 	mergedArray[k++] = array[i++];
        // }

        // for(i = left; i <= right; i++) {
        // 	array[i] = mergedArray[i];
        // }
        // return inversionCount;
	}
}

public class MaxSubarraySum {

	public static int[] dynamicProgram(final int A[], int length) { // complete this function
	}

	public static int[] divideAndConquer(final int A[], int length) {
		return divideAndConquer(A, 0, length - 1);
	}

	private static int[] divideAndConquer(final int array[], int left, int right) {
		if (left == right) {
			int answer[] = new int[3];
			answer[0] = array[left];
			answer[1] = left;
			answer[2] = right;
			return answer;
		} else {
			int mid = (left + right) / 2;
			int leftAnswer[] = divideAndConquer(array, left, mid);
			int rightAnswer[] = divideAndConquer(array, mid + 1, right);
			int crossAnswer[] = cross(array, left, right, mid);
			if (leftAnswer[0] > rightAnswer[0] && leftAnswer[0] > crossAnswer[0])
				return leftAnswer;
			else if (rightAnswer[0] > leftAnswer[0] && rightAnswer[0] > crossAnswer[0])
				return rightAnswer;
			else
				return crossAnswer;
		}
	}

	private static int[] cross(final int[] array, int left, int right, int mid) {
		int maxSumLeft = array[mid], maxSumRight = array[mid + 1];
		int sum = array[mid];
		int startIndex = mid, endIndex = mid + 1;
		for (int i = mid - 1; i >= left; i--) {
			sum += array[i];
			if (sum > maxSumLeft) {
				maxSumLeft = sum;
				startIndex = i;
			}
		}
		sum = array[mid + 1];
		for (int i = mid + 2; i <= right; i++) {
			sum += array[i];
			if (sum > maxSumRight) {
				maxSumRight = sum;
				endIndex = i;
			}
		}
		int answer[] = new int[3];
		answer[0] = maxSumLeft + maxSumRight;
		answer[1] = startIndex;
		answer[2] = endIndex;
		return answer;
	}

	public static int[] bruteForce(final int A[], int length) {
		int globalMax = A[0];
		int globalStartIndex = 0, globalEndIndex = 0;
		for (int i = 0; i < length; i++) {
			int sum = A[i];
			for (int j = i + 1; j < length; j++) {
				sum += A[j];
				if (sum > globalMax) {
					globalMax = sum;
					globalStartIndex = i;
					globalEndIndex = j;
				}
			}
		}
		int answer[] = new int[3];
		answer[0] = globalMax;
		answer[1] = globalStartIndex;
		answer[2] = globalEndIndex;
		return answer;
	}
}

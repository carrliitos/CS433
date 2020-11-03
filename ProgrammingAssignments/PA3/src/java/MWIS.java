import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MWIS extends Tree {

	public int computedSum[];
	boolean isIncludedSumLarger[];
	boolean isInSet[];

	public MWIS(final String filePath) throws FileNotFoundException {
		super(filePath);
		computedSum = new int[numNodes];
		isIncludedSumLarger = new boolean[numNodes];
		isInSet = new boolean[numNodes];
		for (int i = 0; i < numNodes; i++) {
			computedSum[i] = Integer.MIN_VALUE;
			isIncludedSumLarger[i] = false;
			isInSet[i] = false;
		}
	}

	public int computeSum(int node) {
		if(computedSum[node] != Integer.MIN_VALUE) return computedSum[node];

		int excl = 0;
		int incl = weights[node];
		// still need to finish

	}

	public void computeSet(int root) { // complete this function
	}

	private void computeSetHelper(int node, int parent) { // complete this function
	}
}

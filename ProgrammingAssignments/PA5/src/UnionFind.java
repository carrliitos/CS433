public class UnionFind {

	LinkedList representatives[];

	public UnionFind(int initialNumSets) {
		representatives = new LinkedList[initialNumSets];
		for (int x = 0; x < initialNumSets; x++)
			makeSet(x);
	}

	public void makeSet(int x) { // complete this function
	}

	public LinkedList find(int x) { // complete this function
	}

	private void append(LinkedList arg1, LinkedList arg2) { // complete this function
	}

	public void doUnion(int x, int y) { // complete this function
	}
}

import java.util.ArrayList;

public class AVLApplications extends AVL {

	public AVLApplications(int A[]) {
		for (int a : A)
			insert(a);
	}

	public int select(int k) {
		AVLNode tmp = root;
		while(tmp != null) {
			if(k - 1 == getSubtreeSize(tmp.left)) {
				return tmp.value;
			}else if(k <= getSubtreeSize(tmp.left)) {
				tmp = tmp.left;
			}else {
				k -= 1 + getSubtreeSize(tmp.left);
				tmp = tmp.right;
			}
		}
		return -1;
	}
	
	public int rank(int key) { 
		AVLNode tmp = root;
		int rank = 0;
		while(tmp != null) {
			if(key >= tmp.value) {
				rank += 1 + getSubtreeSize(tmp.left);
				tmp = tmp.right;
			}else {
				tmp = tmp.left;
			}
		}
		return rank;
	}

	public ArrayList<Integer> sortedRangeReporting(int L, int R) {
		AVLNode successor = getSuccessor(L); 
		ArrayList<Integer> arr = new ArrayList<>();
		while(successor != null && successor.value <= R) {
			arr.add(successor.value);
			successor = successor.next;
		}
		return arr;
	}

	public AVLNode getPredecessor(int key) {
		AVLNode tmp = root;
		AVLNode pred = null;
		while (tmp != null) {
			if (tmp.value == key)
				return tmp;
			else if (tmp.value < key) {
				pred = tmp;
				tmp = tmp.right;
			} else {
				tmp = tmp.left;
			}
		}
		return pred;
	}

	public AVLNode getSuccessor(int key) {
		AVLNode tmp = root;
		AVLNode succ = null;
		while (tmp != null) {
			if (tmp.value == key)
				return tmp;
			else if (tmp.value > key) {
				succ = tmp;
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}
		return succ;
	}
}

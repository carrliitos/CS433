public class UnionFind {

	LinkedList representatives[];

	public UnionFind(int initialNumSets) {
		representatives = new LinkedList[initialNumSets];
		for (int x = 0; x < initialNumSets; x++)
			makeSet(x);
	}

	public void makeSet(int x) {
		LinkedList LL = new LinkedList();
		LL.insertAtEnd(x);
		representatives[x] = LL;
	}

	public LinkedList find(int x) {
		return representatives[x];
	}

	private void append(LinkedList arg1, LinkedList arg2) { 
		arg1.tail.next = arg2.head;
		arg1.tail = arg2.tail;
		arg1.size += arg2.size;

		for(int i = 0; i < arg2.size; i++) {
			int y = 0;
			ListNode currentNode = arg2.head;
			while(currentNode != null) {
				if(y == i) representatives[currentNode.value] = arg1;
				y++;
				currentNode = currentNode.next;
			}
		}
		
		arg2.head = null;
		arg2.tail = null;
	}

	public void doUnion(int x, int y) { 
		LinkedList LLx = find(x);
		LinkedList LLy = find(y);

		if(!LLx.equals(LLy)) {
			if(LLx.size >= LLy.size) append(LLx, LLy);
			else append(LLy, LLx);
		}
	}
}

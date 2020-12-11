import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SCC extends Graph {

	private Stack<Integer> someStack;
	private boolean[] closed;

	public SCC(String filePath, GraphType type) throws FileNotFoundException {
		super(filePath, type);
		someStack = new Stack<Integer>();
		closed = new boolean[numVertices];
	}

	private void step1Helper(int v) { // What is the purpose of this method?
		closed[v] = true;
		for (Edge adjEdge : adjList.get(v)) {
			int w = adjEdge.dest;
			if (!closed[w])
				step1Helper(w);
		}
		someStack.push(v);
	}

	private void step1() { // What is the purpose of this method?
		for (int i = 0; i < numVertices; i++)
			closed[i] = false;
		for (int i = 0; i < numVertices; i++)
			if (!closed[i])
				step1Helper(i);
	}

	private ArrayList<ArrayList<Edge>> step2() { // What is the purpose of this method?
		ArrayList<ArrayList<Edge>> anotherAdjList = new ArrayList<ArrayList<Edge>>(numVertices);
		for (int i = 0; i < numVertices; i++)
			anotherAdjList.add(new ArrayList<Edge>());

		for (int i = 0; i < numVertices; i++) {
			for (Edge edge : adjList.get(i)) {
				Edge newEdge = new Edge(edge.dest, edge.src, 1);
				anotherAdjList.get(edge.dest).add(newEdge);
			}
		}
		return anotherAdjList;
	}

	private ArrayList<ArrayList<Integer>> step3(ArrayList<ArrayList<Edge>> anotherAdjList) { // What is the purpose of this method?

		ArrayList<ArrayList<Integer>> scc = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < numVertices; i++)
			closed[i] = false;
		Queue<Integer> queue = new LinkedList<Integer>();

		while (someStack.size() > 0) { // Part 1: What is this while loop doing?
			int u = someStack.pop();
			if (closed[u])
				continue;
			queue.add(u);
			closed[u] = true;
			ArrayList<Integer> component = new ArrayList<Integer>();

			while (queue.size() > 0) { // Part 2: What is this while loop doing and what does it add to component? What algorithm is this?
				int v = queue.poll();
				component.add(v);
				for (Edge adjEdge : anotherAdjList.get(v)) {
					int w = adjEdge.dest;
					if (!closed[w]) {
						closed[w] = true;
						queue.add(w);
					}
				}
			}
			scc.add(component); // Part 3: What is the purpose of this statement?
		}
		return scc;
	}

	public ArrayList<ArrayList<Integer>> execute() {
		step1();
		ArrayList<ArrayList<Edge>> anotherAdjList = step2();
		return step3(anotherAdjList);
	}
}

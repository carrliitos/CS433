import java.util.Arrays;

public class Dijkstra extends Graph {

	public Dijkstra(Graph graph) {
		super(graph);
	}

	public int[] execute(int source) {
		int distance[] = new int[numVertices];
		Arrays.fill(distance, Integer.MAX_VALUE);

		boolean closed[] = new boolean[numVertices];
		Arrays.fill(closed, false);

		PriorityQueue<Integer> open = new PriorityQueue<Integer>();
		open.setPriority(source, 0);
		distance[source] = 0;
		while(open.getSize() > 0) {
			/* 
			* Let minVertex be an open vertex with the minimum distance value. 
			* Use the getMinimumItem() of open to get this vertex. 
			* Delete the minimum in open by calling deleteMinimum().
			*/
			int minVertex = open.getMinimumItem();
			open.deleteMinimum();
			closed[minVertex] = true;

			for(Edge edge : super.adjList.get(minVertex)) {
				int adjVertex = edge.dest;
				if(!closed[adjVertex]) {
					int newDist = distance[minVertex] + edge.weight;
					if(newDist < distance[adjVertex]) {
						distance[adjVertex] = newDist;
						open.setPriority(adjVertex, newDist);
					}
				}
			}
		}

		return distance;
	}
}

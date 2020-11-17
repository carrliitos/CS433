public class BellmanFord extends Graph {

	public BellmanFord(final Graph graph) {
		super(graph);
	}

	public int[] execute(int source) {
		int dist[] = new int[numVertices];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		boolean didDistChange = false;

		for(int i = 1; i <= numVertices - 1; i++) {
			didDistChange = false;
			for(int j = 0; j < numVertices; j++) {
				for(int k = 0; k < adjList.get(j).size(); k++) {
					Edge e = adjList.get(j).get(k);
					if(dist[e.src] == Integer.MAX_VALUE) { continue; }
					int newDist = dist[e.src] + e.weight;
					if(newDist < dist[e.dest]) {
						dist[e.dest] = newDist;
						didDistChange = true;
					}
				}
			}
			if(!didDistChange) { return dist; }
		}
		for(int j = 0; j < numVertices; j++) {
			
		}
	}
}

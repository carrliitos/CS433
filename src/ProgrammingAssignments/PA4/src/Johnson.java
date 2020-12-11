import java.util.ArrayList;

public class Johnson extends Graph {

	public Johnson(final Graph graph) {
		super(graph);
	}

	public int[][] execute() throws Exception {
		adjList.add(new ArrayList<Edge>());
		for(int i = 0; i < numVertices; i++) {
			Edge e = new Edge(numVertices, i, 0);
			adjList.get(numVertices).add(e);
		}

		numEdges += numVertices;
		numVertices++;
		BellmanFord bellmanFord = new BellmanFord(this);
		int phi[] = bellmanFord.execute(numVertices - 1);
		adjList.remove(numVertices - 1);
		numVertices--;
		numEdges -= numVertices;
		if(phi == null) { return null; }
		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < adjList.get(i).size(); j++) {
				Edge e = adjList.get(i).get(j);
				e.weight = e.weight + phi[e.src] - phi[e.dest];
			}
		}

		int allPairMatrix[][] = new int[numVertices][];
		Dijkstra dijsktra = new Dijkstra(this);
		for(int i = 0; i < numVertices; i++) { allPairMatrix[i] = dijsktra.execute(i); }

		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < numVertices; j++) {
				if(i != j && allPairMatrix[i][j] != Integer.MAX_VALUE) {
					allPairMatrix[i][j] = allPairMatrix[i][j] - phi[i] + phi[j];
				}
			}
		}

		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < adjList.get(i).size(); j++) {
				Edge e = adjList.get(i).get(j);
				e.weight = e.weight - phi[e.src] + phi[e.dest];
			}
		}
		
		return allPairMatrix;	
	}
}

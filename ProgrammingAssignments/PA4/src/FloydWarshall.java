import java.util.Arrays;

public class FloydWarshall extends Graph {

	public FloydWarshall(Graph graph) {
		super(graph);
	}

	public int[][] execute() {
		int allPairMatrix[][] = new int[numVertices][numVertices];
		for(int row[] : allPairMatrix) { Arrays.fill(row, Integer.MAX_VALUE); }
		for(int i = 0; i < numVertices; i++) { allPairMatrix[i][i] = 0; }
		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < adjList.get(i).size(); j++) {
				Edge e = adjList.get(i).get(j);
				allPairMatrix[e.src][e.dest] = e.weight;
			}
		}
		
		for(int k = 0; k < numVertices; k++) {
			for(int i = 0; i < numVertices; i++) {
				for(int j = 0; j < numVertices; j++) {
					if(allPairMatrix[i][k] == Integer.MAX_VALUE || 
						allPairMatrix[k][j] == Integer.MAX_VALUE) { continue; }
					int tempDist = allPairMatrix[i][k] + allPairMatrix[k][j];
					if(allPairMatrix[i][j] > tempDist) { allPairMatrix[i][j] = tempDist; }
				}
			}
		}

		for(int i = 0; i < numVertices; i++) {
			if(allPairMatrix[i][i] < 0) { return null; }
		}
		return allPairMatrix;
	}
}

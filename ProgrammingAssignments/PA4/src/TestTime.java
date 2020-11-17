
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TestTime {

	static final String DIJKSTRA_FOLDER = "<FILL IN THE PATH WHERE THE FILES ARE KEPT>";

	static void testDijkstraTime() throws Exception {
		System.out.println("*** Time Test Dijkstra ***\n");
		String fileNames[] = { 
			"DC.len", 
			"RI.len", 
			"VT.len", 
			"SD.len", 
			"MA.len", 
			"WI.len", 
			"IL.len", 
			"FL.len", 
			"CA.len",
			"TX.len" 
		};
		Random rand = new Random(0);
		for (int j = 0; j < fileNames.length; j++) {
			System.out.println("Loading " + fileNames[j] + "...");
			Graph graph = new Graph(DIJKSTRA_FOLDER + fileNames[j], GraphType.WEIGHTED);
			int numSources = 250;
			Dijkstra dijk = new Dijkstra(graph);
			int countUnreachable = 0;
			System.out.println("Graph size: numVertices = " + graph.numVertices + "; numEdges = " + graph.numEdges);
			System.out.println("Running Dijkstra for " + numSources + " sources");
			double timeStart = System.currentTimeMillis();
			for (int i = 0; i < numSources; i++) {
				int v = rand.nextInt(graph.numVertices);
				// System.out.println("Running Dijkstra for source " + v + "...");
				int dist[] = dijk.execute(v);
				for (int k = 0; k < graph.numVertices; k++) {
					if (dist[k] == Integer.MAX_VALUE)
						countUnreachable++;
				}
			}
			double timeEnd = System.currentTimeMillis();
			System.out.println("Avg no. of unreachable vertices is " + countUnreachable / numSources);
			System.out.println("Avg time is " + (timeEnd - timeStart) / (1000 * numSources) + " secs");
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		testDijkstraTime();
	}
}

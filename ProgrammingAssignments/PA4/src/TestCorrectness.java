
import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestCorrectness {

	static final String BELLMANFORD1_GRAPH_PATH = "txtFiles/bellmanford1.txt";
	static final String BELLMANFORD2_GRAPH_PATH = "txtFiles/bellmanford2.txt";
	static final String BELLMANFORD3_GRAPH_PATH = "txtFiles/bellmanford3.txt";

	static final String DIJKSTRA1_GRAPH_PATH = "txtFiles/dijkstra1.txt";
	static final String DIJKSTRA2_GRAPH_PATH = "txtFiles/dijkstra2.txt";

	static final String APSP1_GRAPH_PATH = "txtFiles/apsp1.txt";
	static final String APSP2_GRAPH_PATH = "txtFiles/apsp2.txt";
	static final String APSP3_GRAPH_PATH = "txtFiles/apsp3.txt";

	private static void testDynamicProgramming() {
		for (int i = 1; i <= 15; i++)
			System.out.printf("Number of %2d-length binary strings with no consecutive ones is %4d%n", i,
					DynamicProgramming.numberOfBinaryStringsWithNoConsecutiveOnes(i));

		System.out.println();
		int[] seq0 = { 10, 22, 9, 33, 21, 50, 41, 60, 55, 57 };
		int[] seq1 = { 10, 22, 9, 33, 21, 50, 41, 60, 7 };
		int[] seq2 = { -1, 2, 0, 4, 8, 5, 7, 10, 3 };
		int[] seq3 = { -30, 10, -20, 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int[][] sequences = { seq0, seq1, seq2, seq3 };
		for (int i = 0; i < sequences.length; i++)
			System.out.printf("A Longest Increasing Subsequence of %s is %s%n", Arrays.toString(sequences[i]),
					DynamicProgramming.longestIncreasingSubsequence(sequences[i], sequences[i].length));
	}

	private static void testBellmanFord() throws FileNotFoundException {
		System.out.println("*** Graph 1 ***\n");
		Graph graph = new Graph(BELLMANFORD1_GRAPH_PATH, GraphType.WEIGHTED);
		BellmanFord bf = new BellmanFord(graph);
		for (int i = 0; i < graph.numVertices; i++) {
			String distArray = Arrays.toString(bf.execute(i)).replaceAll("" + Integer.MAX_VALUE, "inf");
			System.out.printf("Distances from v%d: %s%n", i, distArray);
		}

		System.out.println("\n*** Graph 2 ***");
		graph = new Graph(BELLMANFORD2_GRAPH_PATH, GraphType.WEIGHTED);
		bf = new BellmanFord(graph);
		if (bf.execute(0) == null)
			System.out.println("\nHas a negative cycle.");
		else
			System.out.println("\nSomething is wrong.");

		System.out.println("\n*** Graph 3 ***\n");
		graph = new Graph(BELLMANFORD3_GRAPH_PATH, GraphType.WEIGHTED);
		bf = new BellmanFord(graph);
		for (int i = 0; i < graph.numVertices; i++) {
			String distArray = Arrays.toString(bf.execute(i)).replaceAll("" + Integer.MAX_VALUE, "inf");
			System.out.printf("Distances from v%d: %s%n", i, distArray);
		}
	}

	private static void testDijkstra() throws Exception {
		String filePaths[] = { DIJKSTRA1_GRAPH_PATH, DIJKSTRA2_GRAPH_PATH };
		for (int j = 0; j < filePaths.length; j++) {
			System.out.println("*** Graph " + (j + 1) + " ***\n");
			Graph graph = new Graph(filePaths[j], GraphType.WEIGHTED);
			Dijkstra dijk = new Dijkstra(graph);
			for (int i = 0; i < dijk.numVertices; i++) {
				int[] distance = dijk.execute(i);
				System.out.println("Distance array (from v" + i + "): "
						+ Arrays.toString(distance).replaceAll("" + Integer.MAX_VALUE, "inf"));
			}
			System.out.println();
		}
	}

	private static void testAPSP() throws Exception {
		Graph graph = new Graph(APSP1_GRAPH_PATH, GraphType.WEIGHTED);
		Johnson johnson = new Johnson(graph);
		FloydWarshall fw = new FloydWarshall(graph);

		int distArrayJohnson[][] = johnson.execute();
		System.out.println("*** Graph 1 Distance Matrix (using Johnson) ***\n");
		for (int i = 0; i < graph.numVertices; i++)
			System.out.printf("%s%n", Arrays.toString(distArrayJohnson[i]).replaceAll("" + Integer.MAX_VALUE, "infty"));

		System.out.println("\n*** Graph 1 Distance Matrix (using Floyd-Warshall) ***\n");

		int distArrayFW[][] = fw.execute();
		for (int i = 0; i < graph.numVertices; i++)
			System.out.printf("%s%n", Arrays.toString(distArrayFW[i]).replaceAll("" + Integer.MAX_VALUE, "infty"));

		System.out.println();
		graph = new Graph(APSP2_GRAPH_PATH, GraphType.WEIGHTED);
		johnson = new Johnson(graph);
		fw = new FloydWarshall(graph);
		distArrayJohnson = johnson.execute();
		System.out.println("*** Graph 2 Distance Matrix (using Johnson) ***\n");
		for (int i = 0; i < graph.numVertices; i++)
			System.out.printf("%s%n", Arrays.toString(distArrayJohnson[i]).replaceAll("" + Integer.MAX_VALUE, "infty"));

		System.out.println("\n*** Graph 2 Distance Matrix (using Floyd-Warshall) ***\n");

		distArrayFW = fw.execute();
		for (int i = 0; i < graph.numVertices; i++)
			System.out.printf("%s%n", Arrays.toString(distArrayFW[i]).replaceAll("" + Integer.MAX_VALUE, "infty"));

		System.out.println();
		graph = new Graph(APSP3_GRAPH_PATH, GraphType.WEIGHTED);
		johnson = new Johnson(graph);
		fw = new FloydWarshall(graph);
		distArrayJohnson = johnson.execute();
		distArrayFW = fw.execute();
		System.out.println("*** Graph 3 ***\n");
		if (distArrayJohnson != null)
			System.out.println("Something wrong with Johnson's method.");
		else if (distArrayFW != null)
			System.out.println("Something wrong with Floyd-Warshall's method.");
		else
			System.out.println("Has a negative cycle.");
	}

	public static void main(String args[]) throws Exception {
		System.out.println("****************** Dynamic Programming ******************\n");
		testDynamicProgramming();
		System.out.println("\n****************** Bellman-Ford ******************\n");
		testBellmanFord();
		System.out.println("\n****************** Dijkstra ******************\n");
		testDijkstra();
		System.out.println("****************** APSP algorithms ******************\n");
		testAPSP();
	}
}

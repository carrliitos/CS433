import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestCorrectness {

	static final String MST_GRAPH_PATH = "TextFiles/mst_graph.txt";
	static final String SCC1_GRAPH_PATH = "TextFiles/scc1.txt";
	static final String SCC2_GRAPH_PATH = "TextFiles/scc2.txt";
	static final String SCC3_GRAPH_PATH = "TextFiles/scc3.txt";
	static final String SCC4_GRAPH_PATH = "TextFiles/scc4.txt";

	// private static void testUnionFind() {
	// 	UnionFind uf = new UnionFind(16);
	// 	System.out.println("Initial sets are 0-15\n");
	// 	for (int i = 0; i < 15; i += 4) {
	// 		System.out.printf("UNION(%d,%d)%n", i, i + 1);
	// 		uf.doUnion(i, i + 1);
	// 	}
	// 	System.out.println();
	// 	for (int i = 0; i < 16; i++) {
	// 		System.out.printf("List containing %2d: ", i);
	// 		uf.find(i).printList();
	// 	}
	// 	System.out.println("\nUNION(0,5)");
	// 	System.out.println("UNION(10,12)");
	// 	System.out.println("UNION(0,10)\n");
	// 	uf.doUnion(0, 5);
	// 	uf.doUnion(10, 12);
	// 	uf.doUnion(0, 10);
	// 	for (int i = 0; i < 16; i++) {
	// 		System.out.printf("List containing %2d: ", i);
	// 		uf.find(i).printList();
	// 	}
	// 	System.out.println("\nUNION(6,8)");
	// 	System.out.println("UNION(8,5)\n");
	// 	uf.doUnion(6, 8);
	// 	uf.doUnion(8, 5);
	// 	for (int i = 0; i < 16; i++) {
	// 		System.out.printf("List containing %2d: ", i);
	// 		uf.find(i).printList();
	// 	}
	// }

	// private static void testKruskal() throws FileNotFoundException {
	// 	Kruskal kruskal = new Kruskal(MST_GRAPH_PATH, GraphType.WEIGHTED);
	// 	ArrayList<Edge> mst = kruskal.runKruskal();
	// 	int mstWeight = 0;
	// 	for (Edge e : mst)
	// 		mstWeight += e.weight;
	// 	System.out.printf("MST has weight %d%nThe edges are: %s%n", mstWeight, mst);
	// }

	private static void testKMPHelper(String text, String patterns[]) {
		System.out.println("*** Text is " + text + " *** \n");
		int numPatterns = patterns.length;
		for (int i = 0; i < numPatterns; i++) {
			ArrayList<Integer> occurrences = KMP.runKMP(text, patterns[i]);
			System.out.printf("Pattern %-7s has %d occurrence(s): ", patterns[i], occurrences.size());
			System.out.println(occurrences);
		}
		System.out.println();
	}

	private static void testKMP() {
		String text = "AABAACAADAABAABAACAADAAD";
		String patterns[] = { "AABA", "AABAA", "ABA", "CA", "EF", "AAC", "AAD" };
		testKMPHelper(text, patterns);

		text = "MISSISSIPPILY_OR_MISSISSIPPILESSLY";
		patterns = new String[] { "ISS", "ESS", "_", "IPP", "MISS", "LESSLY", "LY", "LESSLIE" };
		testKMPHelper(text, patterns);
	}

	// private static void testSCC() throws FileNotFoundException {
	// 	SCC scc = new SCC(SCC1_GRAPH_PATH, GraphType.UNWEIGHTED);
	// 	ArrayList<ArrayList<Integer>> components = scc.execute();
	// 	System.out.printf("Components of Graph 1 are: %s%n", components);

	// 	scc = new SCC(SCC2_GRAPH_PATH, GraphType.UNWEIGHTED);
	// 	components = scc.execute();
	// 	System.out.printf("Components of Graph 2 are: %s%n", components);

	// 	scc = new SCC(SCC3_GRAPH_PATH, GraphType.UNWEIGHTED);
	// 	components = scc.execute();
	// 	System.out.printf("Components of Graph 3 are: %s%n", components);

	// 	scc = new SCC(SCC4_GRAPH_PATH, GraphType.UNWEIGHTED);
	// 	components = scc.execute();
	// 	System.out.printf("Components of Graph 4 are: %s%n", components);

	// }

	public static void main(String args[]) throws Exception {
		// System.out.println("****************** Union Find ******************\n");
		// testUnionFind();
		// System.out.println("\n****************** Kruskal ******************\n");
		// testKruskal();
		System.out.println("\n****************** KMP ******************\n");
		testKMP();
		// System.out.println("****************** Strongly Connected Components ******************\n");
		// testSCC();
	}
}

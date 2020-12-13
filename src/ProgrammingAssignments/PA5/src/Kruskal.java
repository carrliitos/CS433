import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Kruskal extends Graph {

	public Kruskal(String filePath, GraphType type) throws FileNotFoundException {
		super(filePath, type);
	}

	private void sort() {
		Collections.sort(edgeList);
	}

	public ArrayList<Edge> runKruskal() {
		sort();
		UnionFind objUF = new UnionFind(numVertices);
		ArrayList<Edge> dynamicArray = new ArrayList<Edge>();
		int numEdgesAdded = 0;
		for(Edge e : edgeList) {
			int src = e.src;
			int dest = e.dest;
			if(objUF.find(src) != objUF.find(dest)) {
				objUF.doUnion(src, dest);
				dynamicArray.add(e);
				numEdgesAdded++;

				if(numEdgesAdded == numVertices - 1) break;
			}
		}
		return dynamicArray;
	}
}

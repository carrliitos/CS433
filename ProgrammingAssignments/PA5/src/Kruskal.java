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

	public ArrayList<Edge> runKruskal() { // complete this function
	}
}

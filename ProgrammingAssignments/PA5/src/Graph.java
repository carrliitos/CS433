import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

	public int numVertices;
	public ArrayList<Edge> edgeList;
	public ArrayList<ArrayList<Edge>> adjList;

	public Graph(String filePath, GraphType type) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(filePath));

		numVertices = fileReader.nextInt();
		
		edgeList = new ArrayList<Edge>();
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		
		for (int i = 0; i < numVertices; i++)
			adjList.add(new ArrayList<Edge>());

		while (fileReader.hasNext()) {
			int src = fileReader.nextInt();
			int dest = fileReader.nextInt();
			int weight = type == GraphType.WEIGHTED ? fileReader.nextInt() : 1;
			Edge e = new Edge(src, dest, weight);
			edgeList.add(e);
			adjList.get(src).add(e);
		}
		fileReader.close();
	}
}

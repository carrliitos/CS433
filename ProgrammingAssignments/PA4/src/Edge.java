public class Edge implements Comparable<Edge> {

	public int src, dest, weight;

	public Edge(int src, int dest) {
		this.src = src;
		this.dest = dest;
		this.weight = 1;
	}

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public int compareTo(Edge that) {
		if (this.src < that.src)
			return -1;
		if (this.src > that.src)
			return +1;
		if (this.dest < that.dest)
			return -1;
		if (this.dest > that.dest)
			return +1;
		return 0;
	}
}

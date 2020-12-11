public class Edge implements Comparable<Edge> {

	public int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		else if (this.weight == that.weight) {
			if (this.src < that.src)
				return -1;
			else if (this.src == that.src) {
				if (this.dest <= that.dest)
					return -1;
				else
					return 1;
			} else
				return 1;
		} else
			return 1;
	}

	public String toString() {
		return String.format("<%d, %d, %d>", src, dest, weight);
	}
}

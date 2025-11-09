package eranbe.graph;

public class MatrixUndirectedGraph extends MatrixGraph implements UndirectedGraph {

	public MatrixUndirectedGraph(int numNodes) {
		super(numNodes);
	}

	@Override
	public void addEdge(int node1, int node2) {
		if (node1 == node2) {
			System.err.println("Can't add self edge for node " + node1);
			return;
		}
		adjacencyMatrix[node1][node2] = 1;
		adjacencyMatrix[node2][node1] = 1;
	}

	@Override
	public void removeEdge(int node1, int node2) {
		adjacencyMatrix[node1][node2] = 0;
		adjacencyMatrix[node2][node1] = 0;
	}

	@Override
	public int degree(int node) {
		int count = 0;
		for (int i = 0; i < adjacencyMatrix.length; i++)
			count += adjacencyMatrix[node][i];
		return count;
	}

	@Override
	public int numEdges() {
		int count = 0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				count += adjacencyMatrix[i][j];
			}
		}
		return count / 2;
	}

	@Override
	public int unconnectedNodes() {
		int count = 0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			boolean hasEdge = false;
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				if (adjacencyMatrix[i][j] == 1) {
					hasEdge = true;
				}
			}
			if (!hasEdge) {
				count++;
			}
		}
		return count;
	}

	@Override
	public UndirectedGraph inverse() {
		MatrixUndirectedGraph result = new MatrixUndirectedGraph(adjacencyMatrix.length);
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				result.adjacencyMatrix[i][j] = adjacencyMatrix[i][j] == 0 ? 1 : 0;
			}
		}
		return result;
	}

	@Override
	public DirectedGraph toDirectedGraph() {
		MatrixDirectedGraph result = new MatrixDirectedGraph(adjacencyMatrix.length);
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				result.adjacencyMatrix[i][j] = adjacencyMatrix[i][j];
			}
		}
		return result;
	}
}

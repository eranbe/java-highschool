package eranbe.graph;

public class MatrixDirectedGraph extends MatrixGraph implements DirectedGraph {

	public MatrixDirectedGraph(int numNodes) {
		super(numNodes);
	}

	@Override
	public void addEdge(int node1, int node2) {
		if (node1 == node2) {
			System.err.println("Can't add self edge for node " + node1);
			return;
		}
		adjacencyMatrix[node1][node2] = 1;
	}

	@Override
	public void removeEdge(int node1, int node2) {
		adjacencyMatrix[node1][node2] = 0;
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numEdges() {
		int count = 0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				count += adjacencyMatrix[i][j];
			}
		}
		return count;
	}

	@Override
	public int unconnectedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DirectedGraph toDirectedGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outgoingDegree(int node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int incomingDegree(int node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DirectedGraph transpose() {
		MatrixDirectedGraph result = new MatrixDirectedGraph(adjacencyMatrix.length);
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				result.adjacencyMatrix[i][j] = adjacencyMatrix[j][i];
			}
		}
		return result;
	}

	@Override
	public DirectedGraph infra() {
		// TODO Auto-generated method stub
		return null;
	}

}

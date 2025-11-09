package eranbe.graph;

abstract class MatrixGraph implements Graph {
	protected int[][] adjacencyMatrix;
	
	MatrixGraph(int numNodes) {
		adjacencyMatrix = new int[numNodes][numNodes];
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		return adjacencyMatrix[node1][node2] == 1;
	}
	
	@Override
	public void addNode() {
		int[][] newMatrix = new int[adjacencyMatrix.length+1][adjacencyMatrix.length+1];
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length; j++) {
				newMatrix[i][j] = adjacencyMatrix[i][j];
			}
		}
		adjacencyMatrix = newMatrix;
	}
	
	@Override
	public void removeNode(int node) {
		for (int i = 0; i < adjacencyMatrix.length-1; i++) {
			for (int j = node; j < adjacencyMatrix[i].length-1; j++) {
				adjacencyMatrix[i][j] = adjacencyMatrix[i][j+1];
				adjacencyMatrix[j][i] = adjacencyMatrix[i+1][j];
			}
		}
		int[][] newMatrix = new int[adjacencyMatrix.length-1][adjacencyMatrix.length-1];
		for (int i = 0; i < adjacencyMatrix.length-1; i++) {
			for (int j = 0; j < adjacencyMatrix[i].length-1; j++) {
				newMatrix[i][j] = adjacencyMatrix[i][j];
			}
		}
		adjacencyMatrix = newMatrix;
	}
	
	@Override
	public void removeAllEdges(int node) {
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			adjacencyMatrix[i][node] = 0;
			adjacencyMatrix[node][i] = 0;
		}
	}
}

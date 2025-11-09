package eranbe.graph;

public interface Graph {
	void addEdge(int node1, int node2);
	void removeEdge(int node1, int node2);
	void addNode();
	void removeNode(int node);
	void removeAllEdges(int node);
	boolean hasEdge(int node1, int node2);
	int numEdges();
	int unconnectedNodes();
	DirectedGraph toDirectedGraph();
}

package eranbe.graph;

public interface DirectedGraph extends Graph {
	int outgoingDegree(int node);
	int incomingDegree(int node);
	DirectedGraph transpose();
	DirectedGraph infra();
}

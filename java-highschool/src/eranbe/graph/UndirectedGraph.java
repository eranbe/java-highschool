package eranbe.graph;

public interface UndirectedGraph extends Graph {
	int degree(int node);
	UndirectedGraph inverse();
}

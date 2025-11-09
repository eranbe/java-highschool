package eranbe.graph;

import eranbe.datastructures.Node;

public class NodeListUndirectedGraph extends NodeListGraph implements UndirectedGraph {
	
	public NodeListUndirectedGraph(int numNodes) {
		super(numNodes);
	}

	@Override
	public void addEdge(int node1, int node2) {
		nodes[node1] = new Node<>(node2, nodes[node1]);
		nodes[node2] = new Node<>(node1, nodes[node2]);
	}

	@Override
	public void removeEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int degree(int node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UndirectedGraph inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeNode(int node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllEdges(int node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
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
}

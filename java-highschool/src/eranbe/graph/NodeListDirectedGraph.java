package eranbe.graph;

import eranbe.datastructures.Node;

public class NodeListDirectedGraph extends NodeListGraph implements DirectedGraph {
	
	public NodeListDirectedGraph(int numNodes) {
		super(numNodes);
	}

	@Override
	public void addEdge(int node1, int node2) {
		nodes[node1] = new Node<>(node2, nodes[node1]);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectedGraph infra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEdge(int node1, int node2) {
		// TODO Auto-generated method stub
		
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

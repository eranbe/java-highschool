package eranbe.graph;

import eranbe.datastructures.Node;

public abstract class NodeListGraph implements Graph {

	protected Node<Integer>[] nodes;
	
	@SuppressWarnings("unchecked")
	NodeListGraph(int numNodes) {
		nodes = new Node[numNodes];
	}
	
	@Override
	public void addNode() {
		@SuppressWarnings("unchecked")
		Node<Integer>[] newNodes = new Node[nodes.length+1];
		for (int i = 0; i < nodes.length; i++) {
			newNodes[i] = nodes[i];
		}
		nodes = newNodes;
	}
}

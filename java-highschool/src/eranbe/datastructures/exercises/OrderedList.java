package eranbe.datastructures.exercises;

import eranbe.datastructures.Node;

public class OrderedList {
	private Node<NumCount> lst;
	
	public void insertNum(int x) {
		Node<NumCount> p = lst;
		Node<NumCount> q = null;
		// scan the list until we find a NumCount where the num is equal to or
		// greater than x (or we reach the end of the list). While we do that,
		// keep q to always be pointing to the Node before p, so we can use it
		// to fix pointers if we need to add a new node.
		while (p != null && p.getValue().getNum() < x) {
			q = p;
			p = p.getNext();
		}
		if (p != null && p.getValue().getNum() == x) {
			// The list has the value x - just update the existing node.
			p.getValue().setCount(p.getValue().getCount() + 1);
		} else {
			// The list doesn't have the value x yet - create a new node
			NumCount newNumCount = new NumCount(x, 1);
			Node<NumCount> newNode = new Node<NumCount>(newNumCount);
			// Now fix the pointers. Pointing the next of the new node to p is ok even
			// if p is null (because we're adding at the end, or the list was empty). 
			newNode.setNext(p);
			if (q == null) {
				// If q is null then the list was either empty or we had to add a node
				// at the start of the list - fix lst to point to the new node.
				lst = newNode;
			} else {
				// The list wasn't empty or we didn't add at the start - fix the
				// previous node's pointer.
				q.setNext(newNode);
			}
		}
	}
	
	public int valueN(int n) {
		// countSoFar will contain the sum of the counts of all the nodes we saw
		int countSoFar = 0;
		Node<NumCount> p = lst;
		while (p != null) {
			NumCount numCount = p.getValue();
			countSoFar += numCount.getCount();
			if (countSoFar >= n) {
				// we either counted n or greater than n, so this is the value
				// we need
				return numCount.getNum();
			}
			// countSoFar is still less than n - continue to the next node.
			p = p.getNext();
		}
		return Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		String result = "Ordered List: ";
		Node<NumCount> p = lst;
		while (p != null) {
			result += p.getValue().toString();
			p = p.getNext();
		}
		return result;
	}
	
	public static void main(String[] args) {
		OrderedList list = new OrderedList();
		System.out.println(list);
		list.insertNum(5);
		System.out.println(list);
		list.insertNum(5);
		System.out.println(list);
		list.insertNum(6);
		System.out.println(list);
		list.insertNum(3);
		System.out.println(list);
		list.insertNum(4);
		System.out.println(list);
		for (int i = 1; i <=5; i++) {
			System.out.println("valueN at " + i + " is " + list.valueN(i));
		}
	}
}

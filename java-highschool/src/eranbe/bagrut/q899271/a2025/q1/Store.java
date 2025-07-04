package eranbe.bagrut.q899271.a2025.q1;

import eranbe.datastructures.Node;

public class Store {
	private Node<Game> lst;
	
	public Store(Game game) {
		lst = new Node<Game>(game);
	}
	
	public void appendGame(Game game) {
		Node<Game> curr = lst;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(new Node<Game>(game));
	}
	
	public int remove(int n, int pr) {
		int deleteCount = 0;
		Node<Game> curr = lst;
		Node<Game> prev = lst;
		while (curr != null && deleteCount < n) {
			if (curr.getValue().getPrice() == pr) {
				deleteCount++;
				if (curr == lst) {
					lst = curr.getNext();
					prev = lst;
				} else {
					prev.setNext(curr.getNext());
				}
				curr = curr.getNext();
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
		return deleteCount;
	}
	
	public int removeCheap(int num) {
		int sum = 0;
		int count = num;
		while (count > 0) {
			int cheapest = findCheapest();
			sum += cheapest;
			remove(1, cheapest);
			count--;
		}
		return sum;
	}
	
	private int findCheapest() {
		Node<Game> curr = lst;
		int cheapest = Integer.MAX_VALUE;
		while (curr != null) {
			if (curr.getValue().getPrice() < cheapest) {
				cheapest = curr.getValue().getPrice();
			}
			curr = curr.getNext();
		}
		return cheapest;
	}

	@Override
	public String toString() {
		String result = "";
		Node<Game> curr = lst;
		while (curr != null) {
			result = result + curr.getValue() + ", ";
			curr = curr.getNext();
		}
		return result;
	}

	public static void main(String[] args) {
		Store store = constructStore();
		System.out.println(store);
		System.out.println(store.remove(3, 30));
		System.out.println(store);
		store = constructStore();
		System.out.println(store);
		System.out.println(store.remove(5, 30));
		System.out.println(store);
		store = constructStore();
		System.out.println(store);
		System.out.println(store.removeCheap(5));
		System.out.println(store);

	}

	private static Store constructStore() {
		Store s = new Store(new Game("a", 30));
		s.appendGame(new Game("g", 30));
		s.appendGame(new Game("b", 27));
		s.appendGame(new Game("v", 99));
		s.appendGame(new Game("k", 30));
		s.appendGame(new Game("c", 25));
		s.appendGame(new Game("p", 30));
		return s;
	}
}

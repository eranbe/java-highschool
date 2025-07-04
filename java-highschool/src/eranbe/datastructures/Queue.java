package eranbe.datastructures;

public class Queue<T> {
	private Node<T> first;
	private Node<T> last;

	public Queue() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void insert(T value) {
		if (this.last == null) { // queue is empty
			this.first = new Node<T>(value);
			this.last = this.first;
		} else {
			this.last.setNext(new Node<T>(value));
			this.last = this.last.getNext();
		}
	}

	public T remove() {
		T value = this.first.getValue();
		this.first = this.first.getNext();
		if (this.first == null) {
			this.last = null;
		}
		return value;
	}
	
	public T head() {
		return this.first.getValue();
	}

	/**
	 * Extract all the elements from the queue and add them to a string.
	 * Because this is a destructive operation, store all the extracted
	 * elements in a temporary queue, and at the end re-build the queue
	 * from the elements we saved, in order, in the temp queue. 
	 */
	public String toString() {
		String result = "[";
		// A queue for storing all the elements as we remove them from this
		Queue<T> tempQ = new Queue<T>();
		while (!this.isEmpty()) {
			T value = this.remove();
			tempQ.insert(value);
			result = result + value.toString();
			// Don't put a comma after the last element of the queue
			if (!this.isEmpty()) {
				result = result + ",";
			}
		}
		// "this" is now empty. Re-build it from the values we kept in tempQ
		while (!tempQ.isEmpty()) {
			this.insert(tempQ.remove());
		}
		result = result + "]"; 
		return result;
	}
	
	private static <T> void rebuildFromThrowAwayCopy(Queue<T> q, Queue<T> qTemp) {
		// rebuild q
		while (!qTemp.isEmpty()) {
			q.insert(qTemp.remove());
		}
	}

	public static <T> T getKthElement(Queue<T> queue, int k) {
		int count = 0;
		Queue<T> tempQ = new Queue<T>();
		T result = null;
		while (count < k && !queue.isEmpty()) {
			result = queue.head();
			tempQ.insert(queue.remove());
			count++;
		}
		// copy the rest to tempQ
		while (!queue.isEmpty()) {
			tempQ.insert(queue.remove());	
		}
		rebuildFromThrowAwayCopy(queue, tempQ);
		return result;
	}

	public static int findLeader(Queue<Integer> q, int k) {
		int position = -1;
		while (!q.isEmpty()) {
			for (int i = 1; i < k; i++) {
				q.insert(q.remove());
			}
			System.out.println(q);
			position = q.remove();
		}
		return position;
	}

	public static <T> Queue<T> clone(Queue<T> q) {
		Queue<T> qTemp = new Queue<T>();
		Queue<T> qCopy = new Queue<T>();
		while (!q.isEmpty()) {
			T val = q.remove();
			qTemp.insert(val);
			qCopy.insert(val);
		}
		rebuildFromThrowAwayCopy(q, qTemp);
		return qCopy;
	}

	public static <T> boolean contains(Queue<T> q, T value) {
		Queue<T> copy = clone(q);
		while (!copy.isEmpty()) {
			if (copy.remove().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static Queue<Integer> unique(Queue<Integer> q) {
		Queue<Integer> qResult = new Queue<Integer>();
		Queue<Integer> qTemp = new Queue<Integer>();
		while (!q.isEmpty()) {
			int val = q.remove();
			if (!contains(qResult, val)) {
				qResult.insert(val);
			}
			qTemp.insert(val);
		}
		rebuildFromThrowAwayCopy(q, qTemp);
		return qResult;		
	}

	public static int getTens(int num) {
		return (num / 10);
	}

	public static Queue<Integer> sortByTens(Queue<Integer> q) {
		Queue<Integer> byTens[] = new Queue[10];
		for (int i = 0; i < byTens.length; i++) {
			byTens[i] = new Queue<Integer>();
		}
		while (!q.isEmpty()) {
			int value = q.remove();
			byTens[value / 10].insert(value);
		}
		Queue<Integer> qResult = new Queue<Integer>();
		for (int i = 0; i < byTens.length; i++) {
			while (!byTens[i].isEmpty()) {
				qResult.insert(byTens[i].remove());
			}
		}
		return qResult;
	}
	
    public static int diff(Queue<Integer> q, int x, int y) {
    	int minDiff = Integer.MAX_VALUE;
		Queue<Integer> qTemp = new Queue<Integer>();
		int currDiff = -1;
    	while (!q.isEmpty()) {
    		int val = q.remove();
    		if (currDiff == -1) {// didn't see x yet
    			if (val == x) { // start counting
    				currDiff = 0;
    			}
    		} else { // saw x
    			currDiff++;
    			if (val == y) { // we have a match, see if we want to update minDiff
    				if (minDiff > currDiff) {
    					minDiff = currDiff; // update
    					currDiff = -1; // reset
    				}
    			} else if (val == x) { // maybe shorter diff. Restart counting
    				currDiff = 0;
    			}
    		}
    		qTemp.insert(val);
    	}
    	rebuildFromThrowAwayCopy(q, qTemp);
    	return minDiff;
    }

	public static void main(String[] args) {
		Queue<Integer> intQ = new Queue<Integer>();
		for (int i = 1; i <= 10; i++) {
			intQ.insert(i);
		}
		System.out.println("initial Q: " + intQ.toString());	
		System.out.println("3rd element: " + getKthElement(intQ, 3));
		System.out.println("1st element: " + getKthElement(intQ, 1));
		System.out.println("10th element: " + getKthElement(intQ, 10));
		System.out.println("11th element: " + getKthElement(intQ, 11));
		
		Queue<Integer> fourQ = clone(intQ);
		System.out.println("Leader for 4: " + findLeader(fourQ, 4));
		Queue<Integer> fiveQ = clone(intQ);
		System.out.println("Leader for 5: " + findLeader(fiveQ, 5));
		Queue<Integer> sevenQ = clone(intQ);
		System.out.println("Leader for 7: " + findLeader(sevenQ, 7));
		Queue<Integer> eightQ = clone(intQ);
		System.out.println("Leader for 8: " + findLeader(eightQ, 8));

		Queue<Integer> dupQueue = new Queue<Integer>();
		dupQueue.insert(1);
		dupQueue.insert(2);
		dupQueue.insert(3);
		dupQueue.insert(1);
		dupQueue.insert(2);
		dupQueue.insert(1);
		dupQueue.insert(4);
		dupQueue.insert(5);
		dupQueue.insert(1);
		dupQueue.insert(2);
		dupQueue.insert(1);
		dupQueue.insert(5);
		Queue<Integer> uniQ = unique(dupQueue);
		System.out.println("Dup q: " + dupQueue);
		System.out.println("Unique q: " + uniQ);
		
		Queue<Integer> evenDecimals = new Queue<Integer>();
		evenDecimals.insert(2);
		evenDecimals.insert(22);
		evenDecimals.insert(32);
		evenDecimals.insert(52);
		evenDecimals.insert(4);
		evenDecimals.insert(22);
		evenDecimals.insert(32);
		evenDecimals.insert(8);
		evenDecimals.insert(88);
		evenDecimals.insert(98);
		evenDecimals.insert(74);
		evenDecimals.insert(74);
		evenDecimals.insert(56);
		evenDecimals.insert(54);
		evenDecimals.insert(2);
		evenDecimals.insert(58);
		evenDecimals.insert(58);
		evenDecimals.insert(4);
		System.out.println("even decimals: " + evenDecimals);
		Queue<Integer> sortedDecimals = sortByTens(evenDecimals);
		
		System.out.println("sorted unique decimals by tens: " + sortedDecimals);
		
		Queue<Integer> diffQ = new Queue<Integer>();
		diffQ.insert(9);
		diffQ.insert(4);
		diffQ.insert(4);
		diffQ.insert(9);
		diffQ.insert(4);
		diffQ.insert(4);
		diffQ.insert(4);
		diffQ.insert(2);
		diffQ.insert(2);
		diffQ.insert(6);
		diffQ.insert(9);
		diffQ.insert(3);
		diffQ.insert(2);
		diffQ.insert(5);
		System.out.println("diff Q: " + diffQ);
		System.out.println("diff is:  " + diff(diffQ, 2, 9));
	}
}

package eranbe.classes;

public class Bucket {
	private int capacity;
	private double currentAmount;
	
	public Bucket(int capacity) {
		this.capacity = capacity;
		this.currentAmount = 0;
	}
	
	public void empty() {
		currentAmount = 0;
	}
	
	public boolean isEmpty() {
		return currentAmount <= 0;
	}
	
	public void fill(double ammountToFill) {
		this.currentAmount += ammountToFill;
		if (this.currentAmount > capacity) {
			this.currentAmount = capacity;
		}
	}
	
	public int getCapacity() {
		return capacity;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}
	
	public void pourInto(Bucket bucketInto) {
		double toFill = bucketInto.getCapacity() - bucketInto.getCurrentAmount();
		if (toFill <= 0) {
			return;
		}
		if (toFill > getCurrentAmount()) {
			bucketInto.fill(getCurrentAmount());
			currentAmount = 0;
		} else {
			bucketInto.fill(toFill);
			currentAmount -= toFill;
		}
	}
	
	public String toString() {
		return "The capacity: " + capacity + "\nThe current amount of water:" + currentAmount;
	}
}

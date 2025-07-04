package eranbe.datastructures.exercises;

public class Item {
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	private char ch;
	public Item(int count, char ch) {
		this.count = count;
		this.ch = ch;
	}
	
}

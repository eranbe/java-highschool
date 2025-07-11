package eranbe.datastructures.exercises;

public class NumCount {
	private int num;
	private int count;
	
	public NumCount(int num, int count) {
		this.num = num;
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "(num: " + num + ", count: " + count + ")";
	}
}

package eranbe.bagrut.a2023;

public class Swimmer {
	private int[] arr;
	private String name;
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int deltas(boolean isLonger) {
		int totalDelta = 0;
		for (int i = 1; i < arr.length; i++) {
			int currDelta = arr[i] - arr[i-1]; 
			if (isLonger && currDelta > 0) {
				totalDelta += currDelta;
			} else if (!isLonger && currDelta < 0) {
				totalDelta += -currDelta;
			}
		}
		return totalDelta;
	}

	public boolean improving() {
		return deltas(true) < deltas(false); 
	}
	
	public static void main(String[] args) {
		int[] arr = {45, 52, 50, 53, 38, 38, 42 };
		Swimmer swimmer = new Swimmer();
		swimmer.setArr(arr);
		System.out.println("deltas longer true: " + swimmer.deltas(true));
		System.out.println("deltas longer false: " + swimmer.deltas(false));
		System.out.println("is improving: " + swimmer.improving());
	}
}

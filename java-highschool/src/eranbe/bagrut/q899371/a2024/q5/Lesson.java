package eranbe.bagrut.q899371.a2024.q5;

public class Lesson {
	private int id;
	private int hh;
	private int mm;
	private int duration;
	
	public int getId() {
		return id;
	}
	
	public int getDuration() {
		return duration;
	}
	public boolean isLater(Lesson other) {
		if (this.hh > other.hh) {
			return true;
		} else if (this.hh < other.hh) {
			return false;
		} else {
			return this.mm > other.mm;
		}
	}

	public static int last(Lesson[] arr) {
		int maxId = arr[0].getId();
		int maxIdx = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].isLater(arr[maxIdx])) {
				maxId = arr[i].getId();
				maxIdx = i;
			}
		}
		return maxId;
	}
	
	public static int sumDuration(Lesson[] arr, int id) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getId() == id) {
				sum += arr[i].getDuration();
			}
		}
		return sum;
	}
	
	public static int longest(Lesson[] arr) {
		int maxId = arr[0].getId();
		int maxDuration = sumDuration(arr, maxId);
		for (int i = 1; i < arr.length; i++) {
			int id = arr[i].getId();
			int duration = sumDuration(arr, id);
			if (duration > maxDuration) {
				maxId = id;
				maxDuration = duration;
			}
		}
		return maxId;
	}
}

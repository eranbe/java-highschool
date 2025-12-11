package eranbe.bagrut.q899371.a2023;

public class MyTime {
	private int myMinute;
	private int myHour;
	public int getMyMinute() {
		return myMinute;
	}
	public void setMyMinute(int myMinute) {
		this.myMinute = myMinute;
	}
	public int getMyHour() {
		return myHour;
	}
	public void setMyHour(int myHour) {
		this.myHour = myHour;
	}
	public boolean before(MyTime other) {
		if (getMyHour() < other.getMyHour()) {
			return true;
		}
		if (getMyHour() > other.getMyHour()) {
			return false;
		}
		return getMyMinute() < other.getMyMinute();
	}
	
	public int diff(MyTime other) {
		if (before(other)) {
			return other.diff(this);
		}
		// "this" is after "other"
		int minDiff = getMyMinute() - other.getMyMinute();
		int hourDiff = getMyHour() - other.getMyHour();
		int diff = minDiff + 60 * hourDiff;
		System.out.println("diff between " + this.toString() + " and " + other.toString() + " is " + diff + " minutes");
		return diff;
	}
	
	@Override
	public String toString() {
		return getMyHour() + ":" + getMyMinute();
	}
}

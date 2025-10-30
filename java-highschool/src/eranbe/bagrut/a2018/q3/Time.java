package eranbe.bagrut.a2018.q3;

public class Time {
	private int hour, minute;
	public Time(int hour, int minute) {
		if (hour > 23 || hour < 0) {
			this.hour = 0;
		} else {
			this.hour = hour;
		}
		if (minute > 59 || hour < 0) {
			this.minute = 0;
		} else {
			this.minute = hour;
		}
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
}
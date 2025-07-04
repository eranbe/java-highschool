package eranbe.classes.compoundclasses;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Date(int year, int month, int day) { // בנאי מקבל ערכים
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date(Date other) { // בנאי מעתיק
		this.year = other.getYear();
		this.month = other.getMonth();
		this.day = other.getDay();
	}
}

package eranbe.classes.arrayofobjects.yomhashoa;

public class Hasid {
	private String name;
	private int year;
	private String country;
	private int qty;

	public Hasid(String name, int year, String country, int qty) {
		this.name = name;
		this.year = year;
		this.country = country;
		this.qty = qty;
	}

	public int getQty() {
		return this.qty;
	}

	public String getCountry() {
		return this.country;
	}

	public String getName() {
		return this.name;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return this.name + " " + this.year + " " + this.country + " " + this.qty;
	}
}


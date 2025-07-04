package eranbe.classes.arrayofobjects;

public class Child {
	private String name; // שם הילד
	private int yearOfBirth; // שנת לידה
	private int payment; // הסכום ששולם לגן

	// ******************** Constructors *********************
	public Child(String name, int yearOfBirth, int payment) { // בנאי המקבל את ערכי התכונות
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.payment = payment;
	}

	public Child() { // בנאי ברירת מחדל
		this.name = "";
		this.yearOfBirth = 0;
		this.payment = 0;
	}

	public Child(Child ch) {
		this.name = ch.getName();
		this.yearOfBirth = ch.getYearOfBirth();
		this.payment = ch.getPayment();
	}

	// ***************** set + get *****************
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return this.yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String toString() {
		return "Child name= " + this.name + ", year of birth= " + this.yearOfBirth + ", the payment= " + this.payment;
	}

}

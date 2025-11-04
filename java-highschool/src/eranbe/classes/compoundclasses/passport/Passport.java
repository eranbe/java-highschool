package eranbe.classes.compoundclasses.passport;

/**
 * see https://docs.google.com/presentation/d/18CDkTqQBFD5WivupAPVH_DIN4IyDLvW4N7UroPoy8Hg/edit?usp=sharing
 */
public class Passport {
	private int pId; // מספר דרכון
	private String name; // שם בעל הדרכון
	public Date issueDate; // תאריך הנפקת הדרכון
	public Date expiryDate; // תאריך פקיעת תוקף הדרכון

	public Passport() { // פעולה בונה ברירת מחדל
		pId = 0;
		name = "";
		issueDate = null;
		expiryDate = null;
	}

	public Passport(int id, String name, Date issueDate, Date expiryDate) { // פעולה בונה המקבלת ערכים
		this.pId = id;
		this.name = name;
		this.issueDate = new Date(issueDate);
		this.expiryDate = new Date(expiryDate);
	}

	public Passport(Passport other) { // פעולה בונה מעתיקה
		this.pId = other.getPId();
		this.name = other.getName();
		this.issueDate = new Date(other.getIssueDate());
		this.expiryDate = new Date(other.getExpiryDate());
	}

	public boolean isExpired2(Date today) {
		if (this.expiryDate.getYear() > today.getYear())
			return false;
		if (this.expiryDate.getYear() == today.getYear() && this.expiryDate.getMonth() > today.getMonth())
			return false;
		if (this.expiryDate.getYear() == today.getYear() && this.expiryDate.getMonth() == today.getMonth()
				&& this.expiryDate.getDay() >= today.getDay())
			return false;
		return true;
	}

	public boolean isExpired(Date today) {
		if (this.expiryDate.getYear() < today.getYear()) {
			return true;
		} else if (this.expiryDate.getYear() == today.getYear()) {
			if (this.expiryDate.getMonth() < today.getMonth()) {
				return true;
			} else if (this.expiryDate.getMonth() == today.getMonth()) {
				return this.expiryDate.getDay() < today.getDay();
			}
		}
		return false;
	}

	public int getPId() {
		return pId;
	}

	public void setPId(int id) {
		this.pId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String toString() {
		return ("the PId: " + this.pId + "the name: " + this.name + " " + issueDate.toString() + " "
				+ expiryDate.toString());
	}

	public static void main(String[] args) {
		/*
		 * Date yesterday = new Date(2025, 5, 22); Date tomorrow = new Date(2025, 5,
		 * 24); Date today = new Date(2025, 5, 23); Passport p = new Passport(1, "foo",
		 * today, null, today); System.out.println("is birthday: " + isBirthday(p,
		 * today)); Passport pY = new Passport(1, "foo", today, null, yesterday);
		 * Passport pT = new Passport(1, "foo", today, null, tomorrow);
		 * System.out.println("is exp yesterday: " + pY.isExpired(today));
		 * System.out.println("is exp today: " + p.isExpired(today));
		 * System.out.println("is exp tomorrow: " + pT.isExpired(today));
		 */
	}
}

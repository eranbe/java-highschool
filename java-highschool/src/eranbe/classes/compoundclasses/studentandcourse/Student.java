package eranbe.classes.compoundclasses.studentandcourse;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Student {
	private String name;
	private int grade;
	private boolean isExcellent;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
		isExcellent = grade > 90;
	}
	
	public void updateGrade(int bonus) {
		this.grade += bonus;
		if (this.grade > 100) {
			this.grade = 100;
		}
		isExcellent = grade > 90;
	}
	
	public int getGrade() {
		return grade;
	}
}

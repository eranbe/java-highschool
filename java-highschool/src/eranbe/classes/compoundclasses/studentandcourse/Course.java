package eranbe.classes.compoundclasses.studentandcourse;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Course {
	private Student[] allStudents;
	
	public void applyBonusToCourse(int minGrade) {
		for (int i = 0; i < allStudents.length; i++) {
			Student st = allStudents[i];
			if (st.getGrade() < minGrade) {
				st.updateGrade(5);
			}
		}
	}
}

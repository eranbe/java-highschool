package eranbe.classes;

public class StudentArr {
	
	private String name;
	private int id;
	private int[] grades;
	
	public StudentArr(String name, int id, int[] grades) {
		this.name = name;  
		this.id = id;
		this.grades = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			this.grades[i] = grades[i];
		}
	}

	public StudentArr() {
		this.name = "";  
		this.id = 0;
		this.grades = new int[10];
	}

	public StudentArr(StudentArr other) {
		this.name = other.name;  
		this.id = other.id;
		this.grades = new int[other.grades.length];
		for (int i = 0; i < other.grades.length; i++) {
			this.grades[i] = other.grades[i];
		}
	}

	public String getName() { 
		return this.name; 
	}

	public int getId() { 
		return this.id;
	}
	
	public int[] getGrades() {
		int[] copy = new int[this.grades.length];
		for (int i = 0; i < this.grades.length; i++) {
			copy[i] = this.grades[i];
		}
		return copy;
	}
	
	public int getGradeByIndex(int i) {
		return this.grades[i];
	}
	
	public int getNumberOfGrades() {
		return this.grades.length;  
	}

	public void setName(String name) { 
		this.name = name;
	}
	
	public void setId(int id) { 
		this.id = id; 
	}
	
	public void setGrades(int[] grades) {
		this.grades = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			this.grades[i] = grades[i];
		}
	}
	
	public void setGradeByIndex(int i, int grade) {
		this.grades[i] = grade;
	}

	public String toString()  {
		String result = "StudentArr[\n";
		result = result + "Name: " + this.name + "\n";
		result = result + "Id: " + this.id + "\n";
		for (int i=0; i < this.grades.length; i++)
		      result = result + "Grade #" + (i + 1) + ": " + this.grades[i] + "\n";
		result = result + "]\n";
		return result;
	}
}


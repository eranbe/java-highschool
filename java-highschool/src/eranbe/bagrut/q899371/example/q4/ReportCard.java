package eranbe.bagrut.q899371.example.q4;

public class ReportCard {
	private String stuName;
	private Subject[] subArray;
	
	public String getStuName() {
		return stuName;
	}

	public ReportCard(String name, int num) {
		this.stuName = name;
		this.subArray = new Subject[num];
	}
	
	public double average() {
		if (subArray.length == 0) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i < subArray.length; i++) {
			sum += subArray[i].getGrade();
		}
		return sum / subArray.length;
	}
	
	public boolean isExcellent() {
		return average() >= 85;
	}
	
	public static void printExcellent(ReportCard[] aClass) {
		for (int i = 0; i < aClass.length; i++) {
			if (aClass[i].isExcellent()) {
				System.out.println(aClass[i].getStuName());
			}
		}
	}
}

package eranbe.bagrut.q899371.a2025.q4;

public class Transport {
	private String name;
	private boolean toSchool;
	int num;
	int day;

	// (א)
	public Transport(String name, int num, int day) {
		this.name = name;
		this.num = num;
		this.day = day;
		this.toSchool = true;
	}
	
	// (ב)
	public Transport(int num) {
		this.name = "Aviv";
		this.day = 4;
		if (num < 1 || num > 50) {
			num = 1;
		}
		this.num = num;
		this.toSchool = false;
	}
	
	// (ג)
	public static int dayReport(Transport[] arr, int day, boolean forward) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			Transport transport = arr[i];
			if (transport.isToSchool() == forward && transport.getDay() == day) {
				sum += transport.getNum();
			}
		}
		return sum;
	}
	
	// (ד)
	public static void moreForward(Transport[] arr) {
		for (int day = 1; day <= 6; day++) {
			if (dayReport(arr, day, true) > dayReport(arr, day, false)) {
				System.out.print(day + ", ");
			}
		}
		System.out.println();
	}
	
	public String getName() {
		return name;
	}
	public boolean isToSchool() {
		return toSchool;
	}
	public int getNum() {
		return num;
	}
	public int getDay() {
		return day;
	}
}

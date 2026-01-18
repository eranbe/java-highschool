package eranbe.bagrut.q899371.a2024.q4;

public class TourPackage {
	private int id;
	private int price;
	private int maxTime;
	private int maxData;
	private int extra; 

	public int getExtra() {
		return extra;
	}
	
	public int getId() {
		return id;
	}
	public TourPackage(int id, int price, int maxTime, int maxData) {
		this.id = id;
		this.price = price;
		this.maxTime = maxTime;
		this.maxData = maxData;
		this.extra = 0;
	}
	
	public void setExtra(int minutes, int usage) {
		int extraMinutes = minutes - this.maxTime;
		int extraData  = usage - this.maxData;
		if (extraMinutes > 0) {
			this.extra += extraMinutes;
		}
		if (extraData > 0) {
			this.extra += extraData * 2;
		}
	}
	
	public static int calculate(TourPackage[] packages) {
		int count = 0;
		for (int i = 0; i < packages.length; i++) {
			if (packages[i].getExtra() > 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int[] customers(TourPackage[] packages) {
		int count = calculate(packages);
		int[] result = new int[count];
		int nextEmpty = 0;
		for (int i = 0; i < packages.length; i++) {
			if (packages[i].getExtra() > 0) {
				result[nextEmpty] = packages[i].getId();
				nextEmpty++;
			}
		}
		return result;
	}
}

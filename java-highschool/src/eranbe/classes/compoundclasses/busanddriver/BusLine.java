package eranbe.classes.compoundclasses.busanddriver;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class BusLine {
	private int lineNumber;
	private Driver driver;

	public BusLine(int number, Driver driver) {
		this.lineNumber = number;
		this.driver = new Driver(driver);
	}
	
	public Driver getDriver() {
		return new Driver(driver);
	}
	public static String findMostSeniorDriverName(BusLine[] allLines) {
		if (allLines.length == 0) {
			return "";
		}
		if (allLines.length == 1) {
			return allLines[0].getDriver().getDriverName();
		}
		int idx = 0;
		for (int i = 1; i< allLines.length; i++) {
			if (allLines[i].getDriver().getSeniority() > allLines[idx].getDriver().getSeniority()) {
				idx = i;
			}
		}
		return allLines[idx].getDriver().getDriverName();
	}
	
	public static void main(String[] args) {
		BusLine[] allLines = {
				new BusLine(1, new Driver("John", 10)),
				new BusLine(2, new Driver("Paul", 20)),
				new BusLine(3, new Driver("George", 25)),
				new BusLine(4, new Driver("Ringo", 18)) };
		System.out.println(findMostSeniorDriverName(allLines));
	}
}

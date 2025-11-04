package eranbe.classes.compoundclasses.busanddriver;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Driver {
	private String driverName;
	private int seniority;
	
	public Driver(String name, int seniority) {
		this.driverName = name;
		this.seniority = seniority;
	}
	
	public Driver(Driver other) {
		this.driverName = other.driverName;
		this.seniority = other.seniority;
	}
	
	public String getDriverName() {
		return driverName;
	}
	
	public int getSeniority() {
		return seniority;
	}
}

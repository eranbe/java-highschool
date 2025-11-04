package eranbe.classes.compoundclasses.apartmentandbuilding;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Apartment {
	private String familyName;
	private int rooms;
	private int floor;

	public Apartment(String familyName, int rooms, int floor) {
		this.familyName = familyName;
		this.rooms = rooms;
		this.floor = floor;
	}

	public boolean isBigApartment() {
		return rooms > 4;
	}
	
	public int getFloor() {
		return floor;
	}
}


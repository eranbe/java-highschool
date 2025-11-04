package eranbe.classes.compoundclasses.apartmentandbuilding;

/**
 * See https://docs.google.com/document/d/1LiLxmohM8lLnGIcwSpmDDJghYUb71_zWJpjopkKdZsc/edit?usp=sharing
 */
public class Building {
	private String address;
	private Apartment[] apartments;

	public int countBigApartmentsOnFloor(int floorNum) {
		int count = 0;
		for (int i = 0; i < apartments.length; i++) {
			if (apartments[i].getFloor() == floorNum && apartments[i].isBigApartment()) {
				count++;
			}
		}
		return count;
	}

}

package eranbe.bagrut.a2018.q3;

public class Airport {

	private Flight[] flights;
	
	public boolean isFly() {
		for (Flight flight : flights) {
			if (flight.getName().equals("Sky")) {
				return true;
			}
		}
		return false;
	}
}


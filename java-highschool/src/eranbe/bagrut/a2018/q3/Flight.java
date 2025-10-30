package eranbe.bagrut.a2018.q3;

public class Flight {
	private String name, destination, flightCode;
	private Time flightTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public Time getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Time flightTime) {
		this.flightTime = flightTime;
	}
}
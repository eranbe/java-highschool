package eranbe.bagrut.a2018;

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
	public static class Time {
		private int hour, minute;
		public Time(int hour, int minute) {
			if (hour > 23 || hour < 0) {
				this.hour = 0;
			} else {
				this.hour = hour;
			}
			if (minute > 59 || hour < 0) {
				this.minute = 0;
			} else {
				this.minute = hour;
			}
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getMinute() {
			return minute;
		}
		public void setMinute(int minute) {
			this.minute = minute;
		}
	}
	
	public static class Flight {
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
}


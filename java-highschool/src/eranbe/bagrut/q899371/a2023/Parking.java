package eranbe.bagrut.q899371.a2023;

public class Parking {
	private String id;
	private MyTime in;
	private MyTime out;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MyTime getIn() {
		return in;
	}
	public void setIn(MyTime in) {
		this.in = in;
	}
	public MyTime getOut() {
		return out;
	}
	
	public int total() {
		return getIn().diff(getOut());
	}
	
	public void setOut(MyTime out) {
		this.out = out;
	}
	
	public static void main(String[] args) {
		MyTime in1 = new MyTime();
		in1.setMyHour(7);
		in1.setMyMinute(10);
		MyTime out1 = new MyTime();
		out1.setMyHour(7);
		out1.setMyMinute(58);
		MyTime in2 = new MyTime();
		in2.setMyHour(7);
		in2.setMyMinute(2);
		MyTime out2 = new MyTime();
		out2.setMyHour(9);
		out2.setMyMinute(58);
		MyTime in3 = new MyTime();
		in3.setMyHour(10);
		in3.setMyMinute(2);
		MyTime out3 = new MyTime();
		out3.setMyHour(19);
		out3.setMyMinute(58);
		Parking[] cars = new Parking[3];
		cars[0] = new Parking();
		cars[0].setId("car1");
		cars[0].setIn(in1);
		cars[0].setOut(out1);
		cars[1] = new Parking();
		cars[1].setId("car2");
		cars[1].setIn(in2);
		cars[1].setOut(out2);
		cars[2] = new Parking();
		cars[2].setId("car3");
		cars[2].setIn(in3);
		cars[2].setOut(out3);
		first(cars);
		System.out.println(sumMoney(cars));
	}
	
	public static void first(Parking[] cars) {
		Parking firstCar = cars[0];
		for (int i = 1; i < cars.length; i++) {
			if (cars[i].getIn().before(firstCar.getIn())) {
				firstCar = cars[i];
			}
		}
		System.out.println(firstCar.getId());
	}
	
	public static int sumMoney(Parking[] cars) {
		int totalMoney = 0;
		for (int i = 0; i < cars.length; i++) {
			int minutes = cars[i].total();
			System.out.println(minutes);
			if (minutes > 120) {
				int minutesToAdd = minutes - 120;
				System.out.println("minutes to add: " + minutesToAdd);
				totalMoney += minutesToAdd;
			}
			System.out.println("total so far: " + totalMoney);
		}
		return totalMoney;
	}
}

package eranbe.bagrut.q899271.a2025.q1;

public class Game {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int price;
	
	public Game(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "(" + name + ", " + price + ")";
	}
}

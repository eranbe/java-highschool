package eranbe.simplegames.sevencards;

public class Card {
	public static char CLUB = 'C';
	public static char DIAMOND = 'D';
	public static char HEART = 'H';
	public static char SPADE = 'S';
	private char shape;
	private int value;
	public Card(char shape, int value) {
		this.shape = shape;
		this.value = value;
	}
	public char getShape() { return shape; }
	public int getValue() { return value; }
	@Override
	public String toString() {
		if (value == 11) {
			return "J" + shape;
		} else if (value == 12) {
			return "Q" + shape;
		} else if (value == 13) {
			return "K" + shape; 
		} else if (value == 14) {
			return "A" + shape;
		} else {
			return "" + value + shape;
		}
	}
}

package eranbe.bagrut.q899371.example.q5;

public class Pixel {
	private int red;
	private int green;
	private int blue;
	
	public Pixel(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public boolean isRed() {
		return (red == 255) && (green == 0) && (blue == 0);
	}

	public boolean isGreen() {
		return (red == 0) && (green == 255) && (blue == 0);
	}
	
	public boolean isBlue() {
		return (red == 0) && (green == 0) && (blue == 255);
	}

	public boolean isOther() {
		return !(isRed() || isGreen() || isBlue());
	}
}

package eranbe.classes.points;

public class CartesianPoint extends AbstractPoint {

	private double x, y;
	public CartesianPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getR() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}

	@Override
	public double getTheta() {
		return Math.atan2(getY(), getX());
	}

}

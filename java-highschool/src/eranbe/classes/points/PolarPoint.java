package eranbe.classes.points;

public class PolarPoint extends AbstractPoint {

	double r, theta;
	
	public PolarPoint(double r, double theta) {
		this.r = r;
		this.theta = theta;
	}
	@Override
	public double getX() {
		return getR() * Math.cos(getTheta());
	}

	@Override
	public double getY() {
		return getR() * Math.sin(getTheta());
	}

	@Override
	public double getR() {
		return r;
	}

	@Override
	public double getTheta() {
		return theta;
	}

}

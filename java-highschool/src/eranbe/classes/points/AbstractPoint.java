package eranbe.classes.points;

public abstract class AbstractPoint implements Point {

	// Cartesian methods
	
	@Override
	public double distance(Point p) {
		return Math.sqrt(Math.pow(getX()-p.getX(), 2) + Math.pow(getY()-p.getY(), 2));
	}

	@Override
	public Point middle(Point p) {
		double xMiddle = (getX() + p.getX()) / 2;
		double yMiddle = (getY() + p.getY()) / 2;
		return new CartesianPoint(xMiddle, yMiddle);
	}
	
	@Override
	public Point add(Point p) {
		return new CartesianPoint(getX() + p.getX(), getY() + p.getY());
	}
	
	@Override
	public boolean isPointWithinRectangle(Point corner1, Point corner2) {
		double minX = Math.min(corner1.getX(), corner2.getX());
		double maxX = Math.max(corner1.getX(), corner2.getX());
		double minY = Math.min(corner1.getY(), corner2.getY());
		double maxY = Math.max(corner1.getY(), corner2.getY());
		return (getX() >= minX && getX() <= maxX) && (getY() >= minY && getY() <= maxY); 
	}
	
	// Polar methods
	
	@Override
	public Point rotate(double rotationAngle) {
		double newTheta = getTheta() + rotationAngle;
		newTheta = (newTheta + 2 * Math.PI) % (2 * Math.PI);
		return new PolarPoint(getR(), newTheta);
	}

	@Override
	public Point multiply(Point p) {
		return new PolarPoint(getR() * p.getR(), getTheta() + p.getTheta());
	}
    @Override
    public Point multiply(double factor) {
    	return multiply(new PolarPoint(getR(), 0));
    }
    
    // Mixed methods
    
    @Override
    public double angle(Point p) {
    	double dotProduct = getX() * p.getX() + getY() * p.getY();
    	double cosTheta = dotProduct / (getR() * p.getR());
    	cosTheta = Math.max(-1, Math.min(1, cosTheta)); 
    	return Math.acos(cosTheta);
    }
}

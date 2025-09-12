package eranbe.classes.geometry;

public class Line {
    private double slope;     
    private double intercept; 


    public Line(double slope, double intercept) {
    	this.slope = slope;
    	this.intercept = intercept;
    }

    public Line(Point p1, Point p2) {
        this.slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        this.intercept = p1.getY() - slope * p1.getX();
    }

    public boolean contains(Point p) {
        return p.getY() == yAtX(p.getX());
    }

    public boolean intersects(Line other) {
    	return !(this.slope == other.slope);
    }

    // |s*pX-pY+i| / √(s*s+1)
    public double distanceFrom(Point p) {
        return Math.abs(slope * p.getX() - p.getY() + intercept) / Math.sqrt(slope * slope + 1);
    }

    public double yAtX(double x) {
    	return x * slope + intercept;
    }

    @Override
    public String toString() {
        return "y = " + slope + "x + " + intercept;
    }
}

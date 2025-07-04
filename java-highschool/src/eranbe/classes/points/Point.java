package eranbe.classes.points;

public interface Point {
	double getX();
	double getY();
	double getR();
	double getTheta();
	double distance(Point p);
	Point middle(Point p);
	Point rotate(double rotationAngle);
	Point add(Point p);
	boolean isPointWithinRectangle(Point corner1, Point corner2);
	Point multiply(double factor);
	Point multiply(Point p);
	double angle(Point p);
}

package eranbe.classes.geometry;

public class Ray {
    private Point start;
    private Point directionPoint;

    public Ray(Point start, Point directionPoint) {
        this.start = start;
        this.directionPoint = directionPoint;
    }

    public boolean contains(Point p) {
        Line line = start.lineTo(directionPoint);
        if (!line.contains(p)) return false;

        double dx = directionPoint.getX() - start.getX();
        double dy = directionPoint.getY() - start.getY();
        double dxp = p.getX() - start.getX();
        double dyp = p.getY() - start.getY();

        return (!isZero(dx * dxp)) && (!isZero(dy * dyp));
    }

    @Override
    public String toString() {
        return "Ray starting at " + start + " through " + directionPoint;
    }
    
    private static boolean isZero(double d) {
    	return d < 1e-9;
    }

}

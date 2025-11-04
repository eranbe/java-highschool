package eranbe.classes.geometry;

public class Ellipse {
    private Point center;
    private double a;
    private double b;

    public Ellipse(Point center, double a, double b) {
        this.center = new Point(center);
        this.a = a;
        this.b = b;
    }

    public boolean contains(Point p) {
        double dx = p.getX() - center.getX();
        double dy = p.getY() - center.getY();
        return (dx*dx)/(a*a) + (dy*dy)/(b*b) <= 1;
    }

    public double area() {
        return Math.PI * a * b;
    }

    @Override
    public String toString() {
        return "Ellipse centered at " + center + " with a=" + a + ", b=" + b;
    }
}

package eranbe.classes.geometry;

public class Parabola {
    private double a, b, c;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean contains(Point p) {
        double expectedY = value(p.getX());
        return p.getY() == expectedY;
    }

    public double value(double x) {
    	return a * x * x + b * x + c;
    }

    @Override
    public String toString() {
        return "y = " + a + "x^2 + " + b + "x + " + c;
    }
}

package eranbe.classes.geometry;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public boolean contains(Point p) {
        return center.distanceTo(p) <= radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    // for a circle it's actually circumference 
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle with center " + center + " and radius " + radius;
    }
}

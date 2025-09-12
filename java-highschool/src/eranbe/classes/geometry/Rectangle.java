package eranbe.classes.geometry;

public class Rectangle {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public boolean contains(Point p) {
        return p.getX() >= topLeft.getX() &&
               p.getX() <= topLeft.getX() + width &&
               p.getY() <= topLeft.getY() &&
               p.getY() >= topLeft.getY() - height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle at " + topLeft + " width=" + width + ", height=" + height;
    }
}

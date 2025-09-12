package eranbe.classes.geometry;

public class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
        	this.points[i] = new Point(points[i]);
        }
    }

    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < points.length; i++) {
            sum += points[i].distanceTo(points[(i + 1) % points.length]);
        }
        return sum;
    }

    // 0.5 * ABS(SUM[i:0->n-1](p(i)X*p(i+1)y - p(i+1)X*p(i)Y) )
    public double area() {
        double sum = 0;
        for (int i = 0; i < points.length; i++) {
            Point current = points[i];
            Point next = points[(i + 1) % points.length];
            sum += (current.getX() * next.getY() - next.getX() * current.getY());
        }
        return Math.abs(sum) / 2;
    }

    @Override
    public String toString() {
        String result = "Polygon: [";
        for (int i = 0; i < points.length; i++) {
        	result = result + points[i] + " ";
        }
        result = result + "]";
        return result;
    }
}

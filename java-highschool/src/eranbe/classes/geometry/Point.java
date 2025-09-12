package eranbe.classes.geometry;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    // הזזת נקודה
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // מרחק לנקודה אחרת
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // קו העובר דרך שתי נקודות
    public Line lineTo(Point other) {
        return new Line(this, other);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

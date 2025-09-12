package eranbe.classes.geometry;

public class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(Point p) {
        Line line = start.lineTo(end);
        if (!line.contains(p)) return false;

        double minX = Math.min(start.getX(), end.getX());
        double maxX = Math.max(start.getX(), end.getX());
        double minY = Math.min(start.getY(), end.getY());
        double maxY = Math.max(start.getY(), end.getY());

        return (p.getX() >= minX - 1e-9 && p.getX() <= maxX + 1e-9) &&
               (p.getY() >= minY - 1e-9 && p.getY() <= maxY + 1e-9);
    }

    @Override
    public String toString() {
        return "Segment from " + start + " to " + end;
    }
}

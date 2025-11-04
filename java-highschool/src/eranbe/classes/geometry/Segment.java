package eranbe.classes.geometry;

public class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public void setStart(Point p) {
    	this.start = new Point(p);
    }
    
    public void setEnd(Point p) {
    	this.end = new Point(p);
    }
    
    public Point getStart() {
    	return new Point(this.start);
    }
    
    public Point getEnd() {
    	return new Point(this.end);
    }
    
    public boolean contains(Point p) {
    	Ray r1 = new Ray(start, end);
    	Ray r2 = new Ray(end, start);
    	return r1.contains(p) && r2.contains(p);
    }

    @Override
    public String toString() {
        return "Segment from " + start + " to " + end;
    }
}

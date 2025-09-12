package eranbe.classes.geometry;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 6);
        Point p3 = new Point(2, 4);

        Line line = p1.lineTo(p2);
        System.out.println(line);
        System.out.println("p3 on line? " + line.contains(p3));

        Ray ray = new Ray(p1, p2);
        System.out.println(ray);
        System.out.println("p3 on ray? " + ray.contains(p3));

        Segment segment = new Segment(p1, p2);
        System.out.println(segment);
        System.out.println("p3 on segment? " + segment.contains(p3));

        Parabola parabola = new Parabola(1, 0, 0);
        System.out.println(parabola);
        System.out.println("p3 on parabola? " + parabola.contains(p3));

        Circle circle = new Circle(p1, 3);
        System.out.println(circle);
        System.out.println("p2 in circle? " + circle.contains(p2));

        Rectangle rect = new Rectangle(new Point(0, 5), 4, 5);
        System.out.println(rect);
        System.out.println("p3 in rectangle? " + rect.contains(p3));

        Triangle triangle = new Triangle(new Point(0,0), new Point(4,0), new Point(2,3));
        System.out.println(triangle);
        System.out.println("Triangle area: " + triangle.area() + ", perimeter: " + triangle.perimeter());

        Polygon poly = new Polygon(new Point[]{new Point(0,0), new Point(4,0), new Point(4,3), new Point(0,3)});
        System.out.println(poly);
        System.out.println("Polygon area: " + poly.area() + ", perimeter: " + poly.perimeter());

        Ellipse ellipse = new Ellipse(new Point(0,0), 4, 2);
        System.out.println(ellipse);
        System.out.println("Point (2,1) in ellipse? " + ellipse.contains(new Point(2,1)));
    }
}

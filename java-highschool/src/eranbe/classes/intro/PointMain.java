package eranbe.classes.intro;

import java.util.Scanner;

public class PointMain {
	public static void main(String[] args)	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter x and y of upper left rectangle corner");
		int x = in.nextInt();
		int y = in.nextInt();
		Point upperLeft = new Point();
		upperLeft.setX(x);
		upperLeft.setY(y);
		System.out.println("Enter x and y of lower right rectangle corner");
		x = in.nextInt();
		y = in.nextInt();
		Point lowerRight = new Point();
		lowerRight.setX(x);
		lowerRight.setY(y);
		// other points of the rectangle.
		Point upperRight = new Point();
		upperRight.setX(lowerRight.getX());
		upperRight.setY(upperLeft.getY());
		Point lowerLeft = new Point();
		lowerLeft.setX(upperLeft.getX());
		lowerLeft.setY(lowerRight.getY());
		// Print the corners
		System.out.println("Upper right: " + "(X=" + upperRight.getX() + " Y=" + upperRight.getY() + ")");
		System.out.println("Lower left: " + "(X=" + lowerLeft.getX() + " Y=" + upperRight.getY() + ")");
	}
}


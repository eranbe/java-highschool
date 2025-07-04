package eranbe;

import java.util.*;

public class MethodCalls {
  public static void main(String[] args) {
	  int num1, num2;
	  Scanner in = new Scanner(System.in);
	  System.out.println("enter num1");
	  num1 = in.nextInt();
	  System.out.println("enter num2");
	  num2 = in.nextInt();
	  int max = calcMax(num1, num2);
	  printNumWithMessage(max, "Max:");
	  int min = calcMin(num1, num2);
	  printNumWithMessage(min, "Min:");
  }

private static int calcMin(int num1, int num2) {
	if (num1 < num2) {
		return num1;
	}
	return num2;
}

private static int calcMax(int num1, int num2) {
	if (num1 > num2) {
		return num1;
	}
	return num2;
}

private static void printNumWithMessage(int num, String message) {
	System.out.println(message + " " + num);
  }
}

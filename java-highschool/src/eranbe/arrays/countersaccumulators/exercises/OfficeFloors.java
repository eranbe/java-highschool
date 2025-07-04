package eranbe.arrays.countersaccumulators.exercises;

import java.util.*;

public class OfficeFloors {
	public static void main(String[] args) {
		int numFloors = 4; //24;
		int numOffices = 3; //3
		int[] floorOccupancy = readEmployees(numFloors, numOffices);
		printEmployeesPerFloor(floorOccupancy);
		printLeastOccupiedFloor(floorOccupancy);
	}

	private static void printLeastOccupiedFloor(int[] floorOccupancy) {
		int min = floorOccupancy[0];
		int minIdx = 0;
		for (int i = 1; i < floorOccupancy.length; i++) {
			if (floorOccupancy[i] < min) {
				min = floorOccupancy[i];
				minIdx = i;
			}
		}
		System.out.println("Least occupied floor: " + (minIdx+1) + " emps: " + min);
	}

	private static void printEmployeesPerFloor(int[] floorOccupancy) {
		for (int i = 0; i < floorOccupancy.length; i++) {
			System.out.println("Floor " + (i+1) + " emps: " + floorOccupancy[i]);
		}
	}

	private static int[] readEmployees(int numFloors, int numOffices) {
		Scanner in = new Scanner(System.in);
		int[] floors = new int[numFloors];
		for (int i = 0; i < numFloors; i++) {
			for (int j = 0; j < numOffices; j++) {
				System.out.println("Enter employees for floor " + (i + 1) + " office " + (j+1));
				int emps = in.nextInt();
				floors[i] += emps;
			}
		}
		return floors;
	}

}

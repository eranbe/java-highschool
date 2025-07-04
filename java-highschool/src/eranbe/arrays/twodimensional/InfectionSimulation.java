package eranbe.arrays.twodimensional;

import java.util.Random;

public class InfectionSimulation {
    static final int SIZE = 5;
    static final int DAYS = 5;
    static final double INFECTION_PROBABILITY = 0.3;

    static final char HEALTHY = 'H';
    static final char SICK = 'S';
    static final char RECOVERED = 'R';

    static Person[][] grid = new Person[SIZE][SIZE];
    static Random rand = new Random();

    public static void main(String[] args) {
        initializeGrid();

        for (int day = 1; day <= DAYS; day++) {
            System.out.println("Day " + day);
            simulateDay();
            printGrid();
            updateSickDays();
            System.out.println("-----------------------");
        }
    }

    public static void initializeGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Person();
            }
        }

        int firstRow = rand.nextInt(SIZE);
        int firstCol = rand.nextInt(SIZE);
        grid[firstRow][firstCol].state = SICK;
        grid[firstRow][firstCol].sickDays = 1;

        System.out.println("Patient zero at: (" + firstRow + ", " + firstCol + ")");
    }

    public static void simulateDay() {
        Person[][] newGrid = copyGrid();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].state == SICK) {
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            if (di != 0 || dj != 0) {
                                infectNeighbor(newGrid, i + di, j + dj);
                            }
                        }
                    }
                }
            }
        }

        grid = newGrid;
    }

    public static void infectNeighbor(Person[][] newGrid, int i, int j) {
        if (i >= 0 && i < SIZE && j >= 0 && j < SIZE) {
            Person neighbor = grid[i][j];
            if (neighbor.state == HEALTHY && rand.nextDouble() < INFECTION_PROBABILITY) {
                newGrid[i][j].state = SICK;
                newGrid[i][j].sickDays = 1;
            }
        }
    }

    public static void updateSickDays() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Person p = grid[i][j];
                if (p.state == SICK) {
                    p.sickDays++;
                    if (p.sickDays > 2) {
                        p.state = RECOVERED;
                    }
                }
            }
        }
    }

    public static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].state + " ");
            }
            System.out.println();
        }
    }

    public static Person[][] copyGrid() {
        Person[][] newGrid = new Person[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                newGrid[i][j] = new Person(grid[i][j]);
            }
        }
        return newGrid;
    }

    static class Person {
        char state;
        int sickDays;

        public Person() {
            this.state = HEALTHY;
            this.sickDays = 0;
        }

        public Person(Person other) {
            this.state = other.state;
            this.sickDays = other.sickDays;
        }
    }
}

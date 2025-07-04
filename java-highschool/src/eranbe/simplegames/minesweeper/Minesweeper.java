package eranbe.simplegames.minesweeper;

import java.util.Random;
import java.util.Scanner;

class Minesweeper {
	private static final int GRID_SIZE = 7;
    public static void main(String[] args) {
        Game game = new Game(GRID_SIZE, GRID_SIZE); // 5x5 grid with 5 mines
        game.start();
    }
}

class Game {
    private final Board board;
    private boolean isGameOver;

    public Game(int size, int numMines) {
        this.board = new Board(size, numMines);
        this.isGameOver = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver) {
            board.printBoard();
            System.out.println("Enter your move: (R for reveal, F for flag/unflag, followed by row and column, e.g., R 1 2 or F 1 2):");
            char action = scanner.next().toUpperCase().charAt(0);
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (!board.isValidCell(row, col)) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (action == 'R') {
                if (board.revealCell(row, col)) {
                    System.out.println("Boom! You hit a mine. Game Over.");
                    isGameOver = true;
                    board.revealAllMines();
                    board.printBoard();
                } else if (board.isWin()) {
                    System.out.println("Congratulations! You cleared the board!");
                    isGameOver = true;
                }
            } else if (action == 'F') {
                board.toggleFlag(row, col);
            } else {
                System.out.println("Invalid action. Use 'R' to reveal or 'F' to flag/unflag.");
            }
        }
        scanner.close();
    }
}

class Board {
    private final int size;
    private final int numMines;
    private final Cell[][] cells;

    public Board(int size, int numMines) {
        this.size = size;
        this.numMines = numMines;
        this.cells = new Cell[size][size];
        initializeBoard();
        placeMines();
        calculateAdjacentMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!cells[row][col].isMine()) {
                cells[row][col].placeMine();
                placedMines++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isMine()) {
                    cells[i][j].setAdjacentMines(countAdjacentMines(i, j));
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValidCell(newRow, newCol) && cells[newRow][newCol].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j].getDisplayChar() + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean revealCell(int row, int col) {
        if (!isValidCell(row, col) || cells[row][col].isRevealed() || cells[row][col].isFlagged()) {
            return false;
        }

        cells[row][col].reveal();
        if (cells[row][col].isMine()) {
            return true; // Game over
        }

        if (cells[row][col].getAdjacentMines() == 0) {
            revealAdjacentCells(row, col);
        }

        return false;
    }

    public void toggleFlag(int row, int col) {
        if (isValidCell(row, col) && !cells[row][col].isRevealed()) {
            cells[row][col].toggleFlag();
        }
    }

    public boolean isWin() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isRevealed() && !cells[i][j].isMine()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void revealAllMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isMine()) {
                    cells[i][j].reveal();
                }
            }
        }
    }

    private void revealAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValidCell(newRow, newCol)) {
                    revealCell(newRow, newCol);
                }
            }
        }
    }
}

class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private char displayChar;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.displayChar = '-';
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public void placeMine() {
        this.isMine = true;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlag() {
        if (isFlagged) {
            isFlagged = false;
            displayChar = '-';
        } else {
            isFlagged = true;
            displayChar = 'F';
        }
    }

    public void reveal() {
        if (!isFlagged) {
            isRevealed = true;
            displayChar = isMine ? '*' : (adjacentMines > 0 ? (char) ('0' + adjacentMines) : ' ');
        }
    }

    public char getDisplayChar() {
        return displayChar;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}

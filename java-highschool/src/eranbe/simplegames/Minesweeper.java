package eranbe.simplegames;

import java.util.Scanner;
import java.util.Random;

public class Minesweeper {
    private static final int SIZE = 5; // Grid size
    private static final int NUM_MINES = 5; // Number of mines
    private static final char MINE = '*';
    private static final char UNREVEALED = '-';
    private static final char EMPTY = ' ';
    
    private static char[][] board = new char[SIZE][SIZE];
    private static boolean[][] mines = new boolean[SIZE][SIZE];
    
    public static void main(String[] args) {
        initializeBoard();
        placeMines();
        playGame();
    }
    
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = UNREVEALED;
                mines[i][j] = false;
            }
        }
    }
    
    private static void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < NUM_MINES) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (!mines[row][col]) {
                mines[row][col] = true;
                placedMines++;
            }
        }
    }
    
    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        
        while (!gameOver) {
            printBoard();
            System.out.println("Enter row and column to reveal (e.g., 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            
            if (mines[row][col]) {
                System.out.println("Boom! You hit a mine. Game Over.");
                gameOver = true;
                revealMines();
                printBoard();
            } else {
                revealCell(row, col);
                if (checkWin()) {
                    System.out.println("Congratulations! You cleared the board!");
                    gameOver = true;
                }
            }
        }
        scanner.close();
    }
    
    private static void revealCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != UNREVEALED) {
            return;
        }
        
        int mineCount = countAdjacentMines(row, col);
        if (mineCount == 0) {
            board[row][col] = EMPTY;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(row + i, col + j);
                }
            }
        } else {
            board[row][col] = (char) ('0' + mineCount);
        }
    }
    
    private static int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && mines[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void revealMines() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mines[i][j]) {
                    board[i][j] = MINE;
                }
            }
        }
    }
    
    private static boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == UNREVEALED && !mines[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

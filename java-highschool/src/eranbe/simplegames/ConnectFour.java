package eranbe.simplegames;

import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    public static void main(String[] args) {
        char[][] board = new char[ROWS][COLUMNS];
        initializeBoard(board);
        boolean gameWon = false;
        char currentPlayer = PLAYER1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Connect Four!");
        printBoard(board);

        while (!gameWon) {
            System.out.print("Player " + currentPlayer + ", choose a column (1-7): ");
            int column;
            try {
                column = Integer.parseInt(scanner.nextLine()) - 1;
                if (column < 0 || column >= COLUMNS) {
                    System.out.println("Invalid column. Please choose between 1 and 7.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue;
            }

            if (!makeMove(board, column, currentPlayer)) {
                System.out.println("Column is full. Choose another column.");
                continue;
            }

            printBoard(board);

            if (checkWin(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                break;
            } else {
                currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
            }
        }

        System.out.println("Game Over. Thanks for playing!");
        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    private static boolean makeMove(char[][] board, int column, char player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY) {
                board[row][column] = player;
                return true;
            }
        }
        return false;
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == player &&
                    board[row][col + 1] == player &&
                    board[row][col + 2] == player &&
                    board[row][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col] == player &&
                    board[row + 2][col] == player &&
                    board[row + 3][col] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (bottom-left to top-right)
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == player &&
                    board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player &&
                    board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonal (top-left to bottom-right)
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == player &&
                    board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player &&
                    board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == EMPTY) {
                return false;
            }
        }
        return true;
    }
}

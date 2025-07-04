package eranbe.simplegames;

import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
    	char[][] board = new char[3][3];
        initializeBoard(board);
        playGame(board, PLAYER_X);
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWinner(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static boolean makeMove(char[][] board, int row, int col, char currentPlayer) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public static void playGame(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean gameEnded = false;
        while (!gameEnded) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!makeMove(board, row, col, currentPlayer)) {
                System.out.println("This move is not valid. Try again.");
            } else if (isWinner(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
            	// Switch players
                if (currentPlayer == PLAYER_X) {
                	currentPlayer = PLAYER_O;
                } else {
                	currentPlayer = PLAYER_X;
                }
            }
        }
        scanner.close();
    }
}

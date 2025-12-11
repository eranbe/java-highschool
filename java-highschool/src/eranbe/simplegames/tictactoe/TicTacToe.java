package eranbe.simplegames.tictactoe;

import java.util.Scanner;

class Board {
    private static final char EMPTY = '-';
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char player) {
        return isRowsWin(player) || isColumnsWin(player) || isMainDiagonalWin(player) || isSecondaryDiagonalWin(player);
    }

	public boolean isMainDiagonalWin(char player) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] != player) {
            	return false;
            }
        }
        return true;
	}

	public boolean isSecondaryDiagonalWin(char player) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != player) {
                return false;
            }
        }
        return true;
	}

	public boolean isColumnsWin(char player) {
		// Check columns
        for (int j = 0; j < size; j++) {
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != player) {
                    colWin = false;
                }
            }
            if (colWin) {
                return true;
            }
        }
        return false;
	}

	public boolean isRowsWin(char player) {
		// Check rows
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != player) {
                    rowWin = false; 
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false;
	}

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != EMPTY) {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    public int getSize() {
        return size;
    }
}

class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

public class TicTacToe {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToe(int boardSize) {
        board = new Board(boardSize);
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        boolean gameOver = false;
        while (!gameOver) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row and column: 0 to " + (board.getSize() - 1) + "): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("This move is not valid. Try again.");
            } else if (board.isWinner(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("The game is a draw!");
                gameOver = true;
            } else {
            	switchPlayer();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the board: ");
        int boardSize = scanner.nextInt();
        TicTacToe game = new TicTacToe(boardSize);
        game.playGame();
        scanner.close();
    }
}

package eranbe.recursion;

public class SolveMaze {
	public static boolean solveMaze(boolean[][] maze, int x, int y, boolean[][] solution) {
	    int n = maze.length;
	    int m = maze[0].length;
	    if (x == n - 1 && y == m - 1) {
	        solution[x][y] = true;
	        return true;
	    }
	    if (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] == false) {
	        solution[x][y] = true;
	        if (solveMaze(maze, x + 1, y, solution) || solveMaze(maze, x, y + 1, solution)) {
	            return true;
	        }
	        solution[x][y] = false;
	    }
	    return false;
	}
	
	public static void print2dArray(boolean[][] maze) {
		for (int i = -1; i <= maze.length; i++) {
			System.out.print('-');
		}
		System.out.println();
		for (int i = 0; i < maze.length; i++) {
			System.out.print('|');
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] ? '*' : ' ');
			}
			System.out.println('|');
		}
		for (int i = -1; i <= maze.length; i++) {
			System.out.print('-');
		}
	}
	
	public static void main(String[] args) {
		boolean[][] maze = { {false, false, true}, { true, false, true}, {true, false, false}};
		boolean[][] solution = new boolean[3][3];
		print2dArray(maze);
		System.out.println("Has solution: " + solveMaze(maze, 0, 0, solution));
		print2dArray(solution);
	}
}

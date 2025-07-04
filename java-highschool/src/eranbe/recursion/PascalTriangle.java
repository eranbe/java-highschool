package eranbe.recursion;

public class PascalTriangle {

    // מתודה רקורסיבית לחישוב מקדם בינומי (n מעל k)
    public static int binomialRecursive(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialRecursive(n - 1, k - 1) + binomialRecursive(n - 1, k);
    }

    // הדפסת משולש פסקל בעזרת רקורסיה
    public static void printPascalRecursive(int rows) {
        System.out.println("Pascal Triangle (Recursive):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(binomialRecursive(i, j) + " ");
            }
            System.out.println();
        }
    }

    // הדפסת משולש פסקל בעזרת לולאות (איטרטיבי)
    public static void printPascalIterative(int rows) {
        System.out.println("Pascal Triangle (Iterative):");
        int[][] triangle = new int[rows][];
        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        // הדפסה
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    // מתודת main להפעלה
    public static void main(String[] args) {
        int numRows = 10;  // ניתן לשנות את מספר השורות

        printPascalRecursive(numRows);
        System.out.println();
        printPascalIterative(numRows);
    }
}


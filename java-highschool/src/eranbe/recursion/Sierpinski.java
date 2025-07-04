package eranbe.recursion;

public class Sierpinski {
    public static void draw(int row, int col, int size, char[][] canvas) {
        if (size == 1) {
            canvas[row][col] = '*';
            return;
        }

        int half = size / 2;

        // שלושת הקודקודים של משולש סרפינסקי
        draw(row, col, half, canvas);                      // למעלה
        draw(row + half, col - half, half, canvas);        // שמאל למטה
        draw(row + half, col + half, half, canvas);        // ימין למטה
    }

    public static void main(String[] args) {
        int size = 32; // חייב להיות חזקת 2
        char[][] canvas = new char[size][2 * size];

        // מילוי ברקע ריק
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 2 * size; j++) {
                canvas[i][j] = ' ';
            }
        }

        draw(0, size - 1, size, canvas);

        // הדפסה
        for (int i = 0; i < size; i++) {
            System.out.println(new String(canvas[i]));
        }
    }
}

package eranbe.recursion;

public class CantorSet {
    public static void draw(String line, int depth) {
        System.out.println(line);

        if (depth == 0) return;

        String next = line.replaceAll("[^ ]", " ");
        int third = line.length() / 3;

        StringBuilder newLine = new StringBuilder(line);
        for (int i = third; i < 2 * third; i++) {
            newLine.setCharAt(i, ' ');
        }

        draw(newLine.toString(), depth - 1);
    }

    public static void main(String[] args) {
        int length = 81; // חזקת 3
        String base = "#".repeat(length);
        draw(base, 5);
    }
}

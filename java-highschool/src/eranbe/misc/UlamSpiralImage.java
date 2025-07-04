package eranbe.misc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class UlamSpiralImage {

    public static void main(String[] args) {
        int n = 501; // חייב להיות אי-זוגי כדי שיהיה מרכז
        BufferedImage image = new BufferedImage(n, n, BufferedImage.TYPE_BYTE_BINARY);

        int[][] spiral = new int[n][n];
        fillSpiral(spiral, n);

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int num = spiral[y][x];
                if (isPrime(num)) {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    image.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

        try {
            ImageIO.write(image, "png", new File("ulam_spiral.png"));
            System.out.println("נשמר קובץ: ulam_spiral.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillSpiral(int[][] spiral, int n) {
        int x = n / 2;
        int y = n / 2;
        spiral[y][x] = 1;
        int num = 2;
        int steps = 1;

        // כיוונים: שמאלה, למטה, ימינה, למעלה
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (num <= n * n) {
            for (int i = 0; i < 4; i++) {
                int dx = directions[i][0];
                int dy = directions[i][1];
                for (int s = 0; s < steps; s++) {
                    x += dx;
                    y += dy;
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        spiral[y][x] = num++;
                    }
                }
                if (i % 2 == 1) {
                    steps++;
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        int sqrt = (int)Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

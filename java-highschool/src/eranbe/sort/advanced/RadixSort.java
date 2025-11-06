package eranbe.sort.advanced;

import java.util.Arrays;

public class RadixSort {

    // פונקציית עזר למציאת המספר המקסימלי (כדי לדעת כמה ספרות יש לו)
    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // מיון מנייה (Counting Sort) שממיין את המערך לפי הספרה שמיוצגת על ידי exp
    // (למשל, exp=1 זה אחדות, exp=10 זה עשרות וכו')
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // מערך עזר לתוצאה
        int[] count = new int[10]; // מערך לספירת המופעים של כל ספרה (0-9)
        for (int i = 0; i < count.length; i++)
        	count[i] = 0;

        // 1. ספירת מופעים של כל ספרה במיקום הנוכחי
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // 2. שינוי count כך שיכיל את המיקומים האמיתיים ב-output
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // 3. בניית מערך הפלט (מהסוף להתחלה כדי לשמור על יציבות!)
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 4. העתקת המערך הממוין זמנית חזרה למערך המקורי
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // הפונקציה הראשית של Radix Sort
    static void radixSort(int[] arr) {
        int n = arr.length;
        int m = getMax(arr, n); // מציאת המספר הגדול ביותר כדי לדעת מתי לעצור

        // ביצוע מיון מנייה לכל ספרה. exp הוא 10 בחזקת i
        // במעבר הראשון exp=1 (אחדות), בשני exp=10 (עשרות), וכן הלאה.
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("לפני המיון:");
        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        System.out.println("אחרי המיון:");
        System.out.println(Arrays.toString(arr));
    }
}
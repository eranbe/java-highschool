package eranbe.sort;

public class SelectionSort {

    /**
     * פעולה המבצעת מיון בחירה על מערך של מספרים שלמים
     * @param arr המערך למיון
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // לולאה חיצונית: מקדמת את הגבול בין החלק הממוין (משמאל) ללא ממוין (מימין)
        for (int i = 0; i < n - 1; i++) {
            // נניח זמנית שהאיבר הראשון בחלק הלא ממוין הוא המינימלי
            int minIdx = i;

            // לולאה פנימית: סורקת את החלק הלא ממוין כדי למצוא את האיבר המינימלי האמיתי
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; // מצאנו איבר קטן יותר, נעדכן את האינדקס שלו
                }
            }

            // החלפה (Swap) בין האיבר הנוכחי (i) לבין האיבר המינימלי שמצאנו (minIdx)
            // מבצעים החלפה רק אם המינימלי הוא לא האיבר שכבר נמצא שם
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // פעולת עזר להדפסת המערך (לצורך בדיקה)
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {29, 10, 14, 37, 13};

        System.out.println("המערך לפני המיון:");
        printArray(data);

        selectionSort(data);

        System.out.println("המערך אחרי המיון:");
        printArray(data);
    }
}
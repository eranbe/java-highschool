package eranbe.sort;

public class BubbleSort {

    /**
     * פעולה המבצעת מיון בועות על מערך של מספרים שלמים
     * @param arr המערך למיון
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = true; // דגל לייעול האלגוריתם

        // לולאה חיצונית: שולטת על מספר המעברים.
        // בכל מעבר, האיבר הגדול ביותר בחלק הלא ממוין "צף" למקומו הנכון בסוף.
        // אם לא בוצעה אף החלפה במעבר שלם, המערך כבר ממוין ואפשר לעצור!
        // זהו שיפור משמעותי ליעילות במקרה הטוב.
        for (int i = 0; i < n - 1 && swapped; i++) {
        	System.out.println(i);
        	swapped = false; // אתחול הדגל בתחילת כל מעבר

            // לולאה פנימית: מבצעת את ההשוואות וההחלפות בזוגות סמוכים.
            // שים לב שהלולאה רצה עד n - 1 - i, כי i האיברים האחרונים כבר ממוינים.
            for (int j = 0; j < n - 1 - i; j++) {
                // אם האיבר הנוכחי גדול מהאיבר הבא אחריו - נחליף ביניהם
                if (arr[j] > arr[j + 1]) {
                    // ביצוע החלפה (Swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    swapped = true; // סימון שבוצעה החלפה במעבר זה
                }
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
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("המערך לפני המיון:");
        printArray(data);

        bubbleSort(data);

        System.out.println("המערך אחרי המיון:");
        printArray(data);

        int[] data2 = {12, 11, 22, 25, 35, 64, 90};

        System.out.println("המערך לפני המיון:");
        printArray(data2);

        bubbleSort(data2);

        System.out.println("המערך אחרי המיון:");
        printArray(data2);

    }
    

}
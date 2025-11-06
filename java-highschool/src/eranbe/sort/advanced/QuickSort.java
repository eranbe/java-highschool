package eranbe.sort.advanced;

public class QuickSort {

    // הפעולה הראשית
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    // הפעולה הרקורסיבית
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // מציאת אינדקס החלוקה (הציר כבר במקומו הסופי)
            int pi = partition(arr, low, high);

            // מיון רקורסיבי של האיברים לפני ואחרי החלוקה
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // פעולת החלוקה (Partition) - הלב של האלגוריתם
    private static int partition(int[] arr, int low, int high) {
        // בחירת האיבר האחרון כציר (Pivot)
        int pivot = arr[high];
        
        // אינדקס האלמנט הקטן יותר (מצביע על הגבול בין הקטנים לגדולים)
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // אם האיבר הנוכחי קטן או שווה לציר
            if (arr[j] <= pivot) {
                i++;

                // החלפה בין arr[i] ל-arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // החלפה אחרונה: שמים את הציר במקומו הנכון (אחרי כל הקטנים ממנו)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // מחזירים את אינדקס הציר
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("לפני מיון מהיר:");
        printArray(arr);

        quickSort(arr);

        System.out.println("אחרי מיון מהיר:");
        printArray(arr);
    }

    // פעולת עזר להדפסה
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
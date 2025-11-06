package eranbe.sort.advanced;

public class MergeSort {

    // הפעולה הראשית שקוראת לפונקציה הרקורסיבית
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // מערך ריק או בעל איבר אחד כבר ממוין
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    // הפעולה הרקורסיבית שמחלקת את המערך
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // מציאת נקודת האמצע

            // מיון רקורסיבי של החצי השמאלי והימני
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // מיזוג שני החצאים הממוינים
            merge(arr, left, mid, right);
        }
    }

    // פעולת העזר למיזוג שני תת-מערכים ממוינים
    private static void merge(int[] arr, int left, int mid, int right) {
        // גודל שני תת-המערכים
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // יצירת מערכי עזר זמניים
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // העתקת נתונים למערכי העזר
        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        // מיזוג מערכי העזר חזרה למערך המקורי
        int i = 0, j = 0;
        int k = left; // אינדקס התחלתי במערך המאוחד

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // העתקת שאריות (אם נשארו) מאחד ממערכי העזר
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("לפני מיון מיזוג:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("אחרי מיון מיזוג:");
        printArray(arr);
    }

    // פעולת עזר להדפסה
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
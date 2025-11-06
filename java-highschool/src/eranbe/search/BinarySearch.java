package eranbe.search;

public class BinarySearch {

    /**
     * חיפוש בינארי איטרטיבי (לולאה).
     * מתאים לכל הרמות, קלאסי ויעיל.
     */
    public static int binarySearchIterative(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            // מציאת נקודת האמצע
            // הערה למתקדמים: (low + high) / 2 עלול לגרום לגלישה במספרים ענקיים,
            // הכתיב low + (high - low) / 2 בטוח יותר, אך בתיכון הגרסה הפשוטה מקובלת.
            int mid = (low + high) / 2;

            // בדיקה האם מצאנו
            if (sortedArr[mid] == target) {
                return mid; // מצאנו! מחזירים את האינדקס
            }

            // אם הערך באמצע קטן מהמטרה, סימן שהמטרה נמצאת בחצי הימני
            if (sortedArr[mid] < target) {
                low = mid + 1; // מצמצמים את טווח החיפוש מימין לאמצע
            } else {
                // אחרת, המטרה חייבת להיות בחצי השמאלי
                high = mid - 1; // מצמצמים את טווח החיפוש משמאל לאמצע
            }
        }

        return -1; // לא נמצא
    }

    /**
     * חיפוש בינארי רקורסיבי.
     * אלגנטי מאוד, מתאים לשאלות בפרק הרקורסיה.
     */
    public static int binarySearchRecursive(int[] sortedArr, int target, int low, int high) {
        // תנאי עצירה: אם תחום החיפוש התרוקן
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        // תנאי עצירה: מצאנו את הערך
        if (sortedArr[mid] == target) {
            return mid;
        }

        // צעד הרקורסיה: בחירה באיזה חצי להמשיך לחפש
        if (sortedArr[mid] < target) {
            return binarySearchRecursive(sortedArr, target, mid + 1, high);
        } else {
            return binarySearchRecursive(sortedArr, target, low, mid - 1);
        }
    }

    // מעטפת נוחה לפונקציה הרקורסיבית (כדי שהמשתמש לא יצטרך לספק low ו-high)
    public static int binarySearchRecursive(int[] sortedArr, int target) {
        return binarySearchRecursive(sortedArr, target, 0, sortedArr.length - 1);
    }

    public static void main(String[] args) {
        int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        System.out.println("מערך: ");
        for(int n : data) System.out.print(n + " ");
        System.out.println("\nמחפשים את: " + target);

        int indexIterative = binarySearchIterative(data, target);
        System.out.println("נמצא (איטרטיבי) באינדקס: " + indexIterative);

        int indexRecursive = binarySearchRecursive(data, target);
        System.out.println("נמצא (רקורסיבי) באינדקס: " + indexRecursive);
    }
}
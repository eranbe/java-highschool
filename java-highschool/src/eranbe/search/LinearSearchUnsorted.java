package eranbe.search;

public class LinearSearchUnsorted {

    /**
     * מבצע חיפוש לינארי במערך לא ממוין.
     * @param arr המערך לחיפוש
     * @param target הערך אותו מחפשים
     * @return האינדקס של הערך אם נמצא, או -1 אם לא נמצא
     */
    public static int linearSearch(int[] arr, int target) {
        // עוברים על כל איברי המערך אחד אחרי השני
        for (int i = 0; i < arr.length; i++) {
            // אם מצאנו את האיבר - מחזירים מיד את המיקום שלו
            if (arr[i] == target) {
                return i;
            }
        }
        // אם סיימנו את הלולאה ולא החזרנו כלום, סימן שהאיבר לא קיים
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        int target = 22;
        int resultIndex = linearSearch(data, target);
        
        if (resultIndex != -1) {
            System.out.println("הערך " + target + " נמצא באינדקס: " + resultIndex);
        } else {
            System.out.println("הערך " + target + " לא נמצא במערך.");
        }
    }
}
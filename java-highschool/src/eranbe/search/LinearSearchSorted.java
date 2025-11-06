package eranbe.search;

public class LinearSearchSorted {

    /**
     * מבצע חיפוש לינארי משופר במערך ממוין (סדר עולה).
     * @param sortedArr המערך הממוין
     * @param target הערך אותו מחפשים
     * @return האינדקס של הערך אם נמצא, או -1 אם לא נמצא
     */
    public static int linearSearchSorted(int[] sortedArr, int target) {
        for (int i = 0; i < sortedArr.length; i++) {
            // אם מצאנו בדיוק את הערך - מעולה
            if (sortedArr[i] == target) {
                return i;
            }
            // השיפור: אם הגענו לאיבר שגדול מהערך המבוקש,
            // כיוון שהמערך ממוין עולה, אין טעם להמשיך לחפש!
            if (sortedArr[i] > target) {
                 // ניתן גם להוסיף הדפסה לימודית: System.out.println("עצרנו מוקדם באינדקס " + i);
                return -1; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedData = {11, 12, 22, 25, 34, 64, 90};
        int target = 24; // ערך שלא קיים, אבל יגרום לעצירה מוקדמת
        
        int resultIndex = linearSearchSorted(sortedData, target);
        if (resultIndex == -1) {
             System.out.println("הערך " + target + " לא נמצא (החיפוש נעצר ביעילות).");
        }
    }
}
package eranbe.sort.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    /**
     * מבצע מיון דליים על מערך של מספרים שלמים חיוביים.
     * לצורך הדוגמה, נניח שאנו רוצים בערך sqrt(n) דליים, אלא אם הטווח קטן מאוד.
     */
    public static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // 1. מציאת הטווח (מינימום ומקסימום) כדי לדעת איך לפזר לדליים
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // קביעת מספר הדליים. אפשר להשתמש בנוסחאות שונות.
        // כאן נשתמש בשורש n ככלל אצבע נפוץ, או במספר קבוע אם רוצים.
        int numBuckets = (int) Math.sqrt(n);
        // מקרה קצה: אם המערך קטן מאוד, לפחות דלי אחד או שניים
        if (numBuckets < 2 && max != min) numBuckets = 2; 
        else if (numBuckets < 1) numBuckets = 1;

        // יצירת הדליים
        List<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // טווח הערכים הכולל
        double range = max - min + 1;

        // 2. פיזור (Scatter): הכנסת איברים לדליים
        for (int num : arr) {
            // נוסחה לנרמול הערך לאינדקס של דלי בין 0 ל-(numBuckets-1)
            int bucketIdx = (int) ((num - min) / range * numBuckets);
            buckets[bucketIdx].add(num);
        }

        // 3. מיון כל דלי בנפרד ואיסוף (Gather) חזרה למערך המקורי
        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            // מיון פנימי של הדלי. 
            // במערכים קטנים מאוד, מיון הכנסה הוא אידאלי. 
            // כאן נשתמש ב-Collections.sort לנוחות (שמשתמש ב-TimSort, סוג של מיזוג והכנסה).
            Collections.sort(bucket);
            
            // העתקה חזרה למערך המקורי
            for (int num : bucket) {
                arr[currentIndex++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {89, 55, 73, 9, 1, 55, 105, 33, 2, 20};
        
        System.out.println("לפני מיון דליים:");
        printArray(data);

        bucketSort(data);

        System.out.println("אחרי מיון דליים:");
        printArray(data);
    }

    // פעולת עזר להדפסה
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}
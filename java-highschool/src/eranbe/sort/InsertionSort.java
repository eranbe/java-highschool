package eranbe.sort;

public class InsertionSort {

    /**
     * פעולה המבצעת מיון הכנסה על מערך של מספרים שלמים
     * @param arr המערך למיון
     */
    public static void insertionSort(int[] arr) {
        // הלולאה החיצונית עוברת על המערך החל מהאיבר השני
        // (אנו מניחים שאיבר בודד בתחילת המערך הוא כבר "תת-מערך ממוין")
        for (int i = 1; i < arr.length; i++) {
            
            int current = arr[i]; // זהו האיבר שאנו רוצים להכניס למקומו הנכון
            int j = i - 1;

            // לולאה פנימית: מזיזה איברים שגדולים מה-current ימינה
            // אנחנו הולכים "אחורה" מהמקום הנוכחי עד להתחלה או עד שמוצאים איבר קטן יותר
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j]; // הזזה ימינה
                j--;
            }
            
            // הכנסת האיבר (current) למקום הנכון שהתפנה
            arr[j + 1] = current;
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
        int[] data = {9, 5, 1, 4, 3};
        
        System.out.println("המערך לפני המיון:");
        printArray(data);
        
        insertionSort(data);
        
        System.out.println("המערך אחרי המיון:");
        printArray(data);
    }
}
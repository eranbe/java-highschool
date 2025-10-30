package eranbe.strings;

public class RepeatingPattern {

    /**
     * בודק האם מחרוזת מורכבת מחזרה של תבנית קצרה יותר (לדוגמה: "ababab" נוצר מ-"ab").
     *
     * @param text המחרוזת לבדיקה.
     * @return true אם המחרוזת כולה היא תבנית חוזרת, false אחרת.
     */
    public static boolean isRepeatingPattern(String text) {

        // בדיקות קצה
        if (text == null || text.length() < 2) {
            return false; // מחרוזות קצרות מדי אינן יכולות להיות תבניות חוזרות
        }

        int n = text.length();

        // לולאה חיצונית: בודקת את כל אורכי התבניות האפשריים.
        // אורך תבנית אפשרי הוא לכל היותר חצי מאורך המחרוזת.
        for (int patternLength = 1; patternLength <= n / 2; patternLength++) {

            // תנאי הכרחי: אורך התבנית חייב להיות מחלק של אורך המחרוזת המלאה.
            // אם לא, אי אפשר למלא את המחרוזת במדויק.
            if (n % patternLength == 0) {

                // נניח שתבנית זו נכונה עד שיוכח אחרת
                boolean patternMatches = true;

                // לולאה פנימית: עוברת על כל תו במחרוזת ומשווה אותו לתו המקביל בתבנית.
                // אם המחרוזת היא "ababab" ואורך התבנית הוא 2 ("ab"):
                // התו במיקום i צריך להיות זהה לתו במיקום i % 2 (מיקום 0 או 1).
                for (int i = 0; i < n; i++) {
                    
                    // i % patternLength נותן את האינדקס של התו בתבנית המקורית
                    if (text.charAt(i) != text.charAt(i % patternLength)) {
                        patternMatches = false; // נמצאה אי-התאמה
                    }
                }

                // אם הלולאה הפנימית הסתיימה ו-patternMatches נשאר true, מצאנו תבנית!
                if (patternMatches) {
                    return true;
                }
            }
        }

        // אם אף אורך תבנית לא נמצא מתאים
        return false;
    }

    // --- קוד ראשי לבדיקה ---
    public static void main(String[] args) {
        System.out.println("--- זיהוי תבנית חוזרת ---");

        String t1 = "ababab";
        String t2 = "abcabcabc";
        String t3 = "aba";
        String t4 = "aabbaa";
        String t5 = "aaaa";
        String t6 = "abcde";
        String t7 = "aabbaabb";

        System.out.println("\"" + t1 + "\" -> " + isRepeatingPattern(t1)); // true (תבנית: "ab")
        System.out.println("\"" + t2 + "\" -> " + isRepeatingPattern(t2)); // true (תבנית: "abc")
        System.out.println("\"" + t3 + "\" -> " + isRepeatingPattern(t3)); // false
        System.out.println("\"" + t4 + "\" -> " + isRepeatingPattern(t4)); // false
        System.out.println("\"" + t5 + "\" -> " + isRepeatingPattern(t5)); // true (תבנית: "a")
        System.out.println("\"" + t6 + "\" -> " + isRepeatingPattern(t6)); // false
        System.out.println("\"" + t7 + "\" -> " + isRepeatingPattern(t7)); // true (תבנית: "aabb")
    }
}
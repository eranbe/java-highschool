package eranbe.conditions;

import java.util.Scanner;

/**
 * תוכנית שמדגימה את השימוש בתנאי מקונן. התוכנית קוראת תו מהמשתמש ומסווגת אותו לאות, ספרה, או אחר
 * התוכנית משתמשת בערכי ה-ASCII
 * של האותיות, ובעובדה שעבור אותיות ועבור מספרים הם ערכים עוקבים, כדי לבדוק אם האות שנקלטה נמצאת בטווח מסוים
 * טווח האותיות הגדולות, טווח האותיות הקטנות, או טווח הספרות
 * אפשר למצוא טבלה למשל בקישור הזה: 
 * https://www.idogendel.com/whitebyte/tools/ascii-table
 */
public class LetterClassify {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char c;
		System.out.println("Enter a char:");
		c = scanner.next().charAt(0);
		// התנאי להלן הוא תנאי מורכב - הוא משלב תנאי "או" ותנאיי "וגם" באותו ביטוי בוליאני
		// הסוגריים מבטיחים שסדר חישוב הערך של הביטוי יהיה כמו שרצינו - מהסוגריים הפנימיים ביותר ועד החיצוניים ביותר
		if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')))
			System.out.println("English letter");
		else {
			// הוראת התנאי השניה (מספר או אחר) מקוננת בתוך בלוק ה-else
			if ((c >= '0') && (c <= '9')) 
				System.out.println("Digit");
			else
				System.out.println("Other");
		}
	}

}

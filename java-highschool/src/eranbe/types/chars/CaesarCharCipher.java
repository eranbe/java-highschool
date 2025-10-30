package eranbe.types.chars;

public class CaesarCharCipher {
	public static void main(String[] args) {
		// --- 1. קלט וקבוע ההזזה ---
        
        char plainChar = 'W';  // האות אותה נרצה להצפין (קלט)
        int shift = 5;         // גודל ההזזה (המפתח)

        // --- 2. הצפנה באמצעות פעולות חשבוניות ומודולו בלבד ---
        
        // א. נירמול: מעביר את האות לטווח 0-25
        // 'W' - 'A' = 22
        int normalizedValue = plainChar - 'A';
        
        // ב. הזזה ומודולו 26: מזיז את הערך ושומר אותו בטווח 0-25 
        // (22 + 5) % 26 = 27 % 26 = 1
        int shiftedValue = (normalizedValue + shift) % 26;
        
        // ג. החזרה: מחזיר את הערך המנוּרמל והמוסט לטווח האותיות
        // 1 + 'A' = 'B'
        char encryptedChar = (char) (shiftedValue + 'A');

        // --- 3. פלט ---
        
        System.out.println("Plain Character: " + plainChar);
        System.out.println("Shift: " + shift);
        System.out.println("Encrypted Character: " + encryptedChar); 
        // פלט סופי: B
	}
}

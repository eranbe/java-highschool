package eranbe.loops;

import java.util.Random;
import java.util.Scanner;

public class MontyHallInteractive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("ברוך הבא לבעיית מונטי הול!");
        System.out.println("יש שלוש דלתות: 0, 1, ו-2. מאחורי אחת מהן יש מכונית ומאחורי השתיים האחרות יש עזים.");
        
        int carDoor = random.nextInt(3); // הדלת עם המכונית
        
        System.out.print("בחר דלת (0, 1, או 2): ");
        int playerChoice = scanner.nextInt();
        
        // מציאת דלת עם עז שלא נבחרה
        int revealedDoor = (playerChoice + 1) % 3;
        if (revealedDoor == carDoor) {
            revealedDoor = (playerChoice + 2) % 3;
        }
        
        System.out.println("המנחה חושף דלת " + revealedDoor + " שבה יש עז.");
        
        System.out.print("האם ברצונך להחליף לדלת השנייה? (הקלד 1 להחלפה, 0 להישאר): ");
        int response = scanner.nextInt();
        
        if (response == 1) {
            playerChoice = 3 - playerChoice - revealedDoor;
        }
        
        if (playerChoice == carDoor) {
            System.out.println("מזל טוב! זכית במכונית!");
        } else {
            System.out.println("אוי, הפסדת! הייתה שם עז.");
        }
        
        scanner.close();
    }
}

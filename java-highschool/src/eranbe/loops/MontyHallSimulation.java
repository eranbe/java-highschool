package eranbe.loops;

import java.util.Random;

public class MontyHallSimulation {
    private static final int NUM_SIMULATIONS = 10000;
    
    public static void main(String[] args) {
        int winsWhenSwitching = 0;
        int winsWhenStaying = 0;
        
        Random random = new Random();
        
        for (int i = 0; i < NUM_SIMULATIONS; i++) {
            int carDoor = random.nextInt(3); // הדלת עם המכונית
            int playerChoice = random.nextInt(3); // הבחירה הראשונית של השחקן
            
            // מציאת דלת עם עז שלא נבחרה
            int revealedDoor = (playerChoice + 1) % 3;
            if (revealedDoor == carDoor) {
                revealedDoor = (playerChoice + 2) % 3;
            }
            
            // אם השחקן מחליף, הוא בוחר את הדלת שלא נבחרה ולא נחשפה
            int switchedChoice = 3 - playerChoice - revealedDoor;
            
            // בדיקת הצלחה
            if (switchedChoice == carDoor) {
                winsWhenSwitching++;
            }
            if (playerChoice == carDoor) {
                winsWhenStaying++;
            }
        }
        
        System.out.println("מספר הניצחונות כאשר השחקן מחליף: " + winsWhenSwitching);
        System.out.println("מספר הניצחונות כאשר השחקן נשאר: " + winsWhenStaying);
        System.out.printf("סיכויי זכייה כאשר מחליפים: %.2f%%\n", (winsWhenSwitching / (double) NUM_SIMULATIONS) * 100);
        System.out.printf("סיכויי זכייה כאשר נשארים: %.2f%%\n", (winsWhenStaying / (double) NUM_SIMULATIONS) * 100);
    }
}

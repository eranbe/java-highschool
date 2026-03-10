package eranbe.classes.intro;

import java.util.Scanner;
import java.util.Random;

public class GameMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rd = new Random(); // שימוש ב-Random כפי שהוגדר בהעדפות
        
        // יצירת שחקן 1
        System.out.println("Enter ID for Player 1:");
        int id1 = in.nextInt();
        Player p1 = new Player();
        p1.setId(id1);
        p1.setPower(rd.nextInt(100) + 1); // הגרלת עוצמה
        
        // יצירת שחקן 2
        System.out.println("Enter ID for Player 2:");
        int id2 = in.nextInt();
        Player p2 = new Player();
        p2.setId(id2);
        p2.setPower(rd.nextInt(100) + 1);
        
        // הצגת נתוני השחקנים
        System.out.println("Player ID " + p1.getId() + " has power: " + p1.getPower());
        System.out.println("Player ID " + p2.getId() + " has power: " + p2.getPower());
        
        // לוגיקת המנצח
        Player winner = new Player();
        if (p1.getPower() == p2.getPower()) {
        	if (p1.getId() < p2.getId()) {
                winner.setId(p1.getId());
                winner.setPower(p1.getPower());
            } else {
                winner.setId(p2.getId());
                winner.setPower(p2.getPower());        		
        	}
        } else if (p1.getPower() > p2.getPower()) {
            winner.setId(p1.getId());
            winner.setPower(p1.getPower());
        } else {
            winner.setId(p2.getId());
            winner.setPower(p2.getPower());
        }
        
        System.out.println("--- Battle Results ---");
        System.out.println("The winner is Player ID: " + winner.getId());
        System.out.println("Winning Power: " + winner.getPower());
    }
}
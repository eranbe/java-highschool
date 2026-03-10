package eranbe.classes.intro;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // יצירת חשבון מקור (א')
        BankAccount acc1 = new BankAccount();
        System.out.println("Enter ID for Account 1:");
        acc1.setId(in.nextInt());
        System.out.println("Enter initial balance:");
        acc1.setBalance(in.nextDouble());
        
        // יצירת חשבון יעד (ב')
        BankAccount acc2 = new BankAccount();
        System.out.println("Enter ID for Account 2:");
        acc2.setId(in.nextInt());
        acc2.setBalance(0); // מתחיל ב-0
        
        // ביצוע ההעברה
        System.out.println("Enter amount to transfer from Acc 1 to Acc 2:");
        double amount = in.nextDouble();
        
        // עדכון חשבון א' (חיסור)
        double newBalance1 = acc1.getBalance() - amount;
        acc1.setBalance(newBalance1);
        
        // עדכון חשבון ב' (הוספה)
        double newBalance2 = acc2.getBalance() + amount;
        acc2.setBalance(newBalance2);
        
        // הדפסת המצב הסופי
        System.out.println("Account " + acc1.getId() + " balance: " + acc1.getBalance());
        System.out.println("Account " + acc2.getId() + " balance: " + acc2.getBalance());
    }
}
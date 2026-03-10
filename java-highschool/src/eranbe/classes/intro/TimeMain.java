package eranbe.classes.intro;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // קליטת זמן התחלה
        System.out.println("Enter class start hour and minute:");
        int h1 = in.nextInt();
        int m1 = in.nextInt();
        Time startTime = new Time();
        startTime.setHour(h1);
        startTime.setMinute(m1);
        
        // קליטת זמן סיום
        System.out.println("Enter class end hour and minute:");
        int h2 = in.nextInt();
        int m2 = in.nextInt();
        Time endTime = new Time();
        endTime.setHour(h2);
        endTime.setMinute(m2);
        
        // חישוב ההפרש בדקות
        // רמז: המירו את כל הזמן לדקות מהשעה 00:00 ואז החסירו
        int startTotalMinutes = startTime.getHour() * 60 + startTime.getMinute();
        int endTotalMinutes = endTime.getHour() * 60 + endTime.getMinute();
        
        int difference = endTotalMinutes - startTotalMinutes;
        
        System.out.println("Class duration in minutes: " + difference);

        // חישוב האמצע בין שני הזמנים - זמן להפסקה
        int breakTimeMinutes = (startTotalMinutes + endTotalMinutes) / 2;
        int breakHours = breakTimeMinutes / 60;
        int breakMinutes = breakTimeMinutes % 60;
        Time breakTime = new Time();
        breakTime.setMinute(breakMinutes);
        breakTime.setHour(breakHours);
        System.out.println("Break time is " + breakTime.getHour() + ":" + breakTime.getMinute());
    }
}

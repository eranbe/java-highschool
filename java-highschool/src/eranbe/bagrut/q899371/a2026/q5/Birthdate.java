package eranbe.bagrut.q899371.a2026.q5;

public class Birthdate {
    private int day;
    private int month;
    private int year;

    public boolean sameDate(Birthdate other) {
        return this.day == other.day 
        		&& this.month == other.month 
        		&& this.year == other.year;
    }
}

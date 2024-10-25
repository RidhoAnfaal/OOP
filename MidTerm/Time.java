package MidTerm;

public class Time {
    int days;

    public Time() {
        this.days = 0;
    }

    public void passDay() {
        days++;
        System.out.println("A day has passed. Total days: " + days);
        System.out.println("");
    }

    public int getDays() {
        return days;
    }
}

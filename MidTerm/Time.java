package MidTerm;

public class Time {
    private int day;
    private String season;

    public Time() {
        this.day = 1;
        this.season = "Spring";
    }

    public void nextDay() {
        day++;
        if (day > 30) {
            day = 1;
            changeSeason();
        }
        System.out.println("Day " + day + " of " + season);
    }

    public void changeSeason() {
        switch (season) {
            case "Spring":
                season = "Summer";
                break;
            case "Summer":
                season = "Fall";
                break;
            case "Fall":
                season = "Winter";
                break;
            case "Winter":
                season = "Spring";
                break;
        }
    }

    public String getSeason() {
        return season;
    }
}

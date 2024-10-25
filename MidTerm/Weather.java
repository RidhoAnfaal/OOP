package MidTerm;

import java.util.Random;

public class Weather {
    private String condition;

    public Weather() {
        this.condition = "Sunny";
    }

    public void changeWeather() {
        String[] conditions = { "Sunny", "Rainy", "Cloudy", "Stormy" };
        Random rand = new Random();
        this.condition = conditions[rand.nextInt(conditions.length)];
        System.out.println("Today's weather is: " + condition + "\n");
    }

    public String getCondition() {
        return condition;
    }

    public boolean isRainy() {
        return condition.equals("Rainy\n");
    }
}

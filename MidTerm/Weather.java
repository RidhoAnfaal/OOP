package MidTerm;

import java.util.Random;

public class Weather {
    String condition;

    public Weather() {
        this.condition = "Sunny\n";
    }

    public void changeWeather() {
        String[] conditions = { "Sunny", "Rainy", "Cloudy", "Stormy" };
        Random rand = new Random();
        this.condition = conditions[rand.nextInt(conditions.length)];
        System.out.println("The weather is now: " + condition);
        System.out.println("");
    }

    public String getCondition() {
        return condition;
    }
}

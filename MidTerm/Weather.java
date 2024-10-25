package MidTerm;

import java.util.Random;

public class Weather {
    private String[] weatherTypes = { "Sunny", "Rainy", "Cloudy" };
    private String currentWeather;
    private int temperature;

    public Weather() {
        changeWeather();
    }

    public void changeWeather() {
        Random rand = new Random();
        currentWeather = weatherTypes[rand.nextInt(weatherTypes.length)];

        switch (currentWeather) {
            case "Sunny":
                temperature = rand.nextInt(6) + 25; // 25 - 30°C
                break;
            case "Rainy":
                temperature = rand.nextInt(6) + 18; // 18 - 23°C
                break;
            case "Cloudy":
                temperature = rand.nextInt(5) + 20; // 20 - 24°C
                break;
        }
        System.out.println("The weather today is " + currentWeather +
                " with a temperature of " + temperature + "°C.\n");
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public boolean isRainy() {
        return currentWeather.equals("Rainy");
    }
}

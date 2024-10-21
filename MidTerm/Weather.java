package MidTerm;

import java.util.Random;

public class Weather {
    private String[] weathers = { "Sunny", "Rainy", "Stormy" };
    private String currentWeather;
    private int temperature;
    private int humidity;
    private int rainfall;

    public Weather() {
        changeWeather();
    }

    public void changeWeather() {
        Random rand = new Random();
        currentWeather = weathers[rand.nextInt(weathers.length)];
        temperature = rand.nextInt(15) + 15; // Random temperature between 15-30
        humidity = rand.nextInt(51) + 50; // Random humidity between 50%-100%
        rainfall = currentWeather.equals("Rainy") ? rand.nextInt(100) : 0; // Random rainfall if rainy
        System.out.println("The weather is " + currentWeather);
        System.out.println(
                "Temperature: " + temperature + "°C, Humidity: " + humidity + "%, Rainfall: " + rainfall + "mm");
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public boolean isRainy() {
        return currentWeather.equals("Rainy");
    }
}

package Jobsheet2.Assignment;

public class Game {
    private String name;
    private double pricePerDay;

    public Game(String name, double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}

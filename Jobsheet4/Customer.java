package Jobsheet4;

public class Customer {
    private String name;
    private Car car;
    private int day;
    private Driver driver;

    public Customer() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return this.car;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return this.day;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public int totalCostCalculation() {
        return car.carCostCalculation(day) +
                driver.dirverCostCalculation(day);
    }
}

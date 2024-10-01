package Jobsheet4;

public class Car {
    private String name;
    private int costs;

    public Car() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public int getCosts() {
        return this.costs;
    }

    public int carCostCalculation(int days) {
        return costs * days;
    }
}
package Jobsheet4;

public class Driver {
    private String name;
    private int cost;

    public Driver() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCosts() {
        return this.cost;
    }

    public int dirverCostCalculation(int days) {
        return cost * days;
    }

}

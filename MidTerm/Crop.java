package MidTerm;

abstract class Crop {
    String name;
    int harvestTime;
    int waterNeeds;
    boolean isSick;
    int daysWatered;

    public Crop(String name, int harvestTime, int waterNeeds) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.isSick = false;
        this.daysWatered = 0;
    }

    public abstract void grow();

    public void harvest() {
        System.out.println("Harvesting " + name);
        System.out.println("");
    }

    public void getSick() {
        isSick = true;
        System.out.println(name + " has gotten sick!");
    }

    public boolean isReadyToHarvest(int days) {
        return days >= harvestTime;
    }

    public void water() {
        daysWatered++;
        System.out.println(name + " has been watered.\n");
    }

    public boolean isHealthy() {
        return !isSick && daysWatered > 0;
    }
}
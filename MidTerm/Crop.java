package MidTerm;

public class Crop {
    private String name;
    private int growthDays;
    private int waterNeededPerDay;
    private int daysWatered;
    private int dailyWaterCount;
    private boolean isHarvestable;
    private boolean isPlanted;

    public Crop(String name, int growthDays, int waterNeededPerDay) {
        this.name = name;
        this.growthDays = growthDays;
        this.waterNeededPerDay = waterNeededPerDay;
        this.daysWatered = 0;
        this.dailyWaterCount = 0;
        this.isHarvestable = false;
        this.isPlanted = false;
    }

    public void water() {
        if (isPlanted) {
            dailyWaterCount++;
            System.out.println(name + " has been watered.");
            checkGrowthStatus();
        } else {
            System.out.println("No plant is planted in this land.");
        }
    }

    private void checkGrowthStatus() {
        if (dailyWaterCount >= waterNeededPerDay) {
            daysWatered++;
            dailyWaterCount = 0; // Reset for the next day
            if (daysWatered >= growthDays) {
                isHarvestable = true;
                System.out.println(name + " is now ready to harvest!");
            }
        }
    }

    public void crop() {
        isPlanted = true;
        daysWatered = 0;
        dailyWaterCount = 0;
        isHarvestable = false;
        System.out.println(name + " has been planted.");
    }

    public boolean isReadyToHarvest() {
        return isHarvestable;
    }

    public String getName() {
        return name;
    }

    public boolean isPlanted() {
        return isPlanted;
    }

    public void reset() {
        isPlanted = false;
        daysWatered = 0;
        dailyWaterCount = 0;
        isHarvestable = false;
    }

    public void nextDay() {
        dailyWaterCount = 0;
    }
}

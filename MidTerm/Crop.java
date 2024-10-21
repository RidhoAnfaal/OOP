package MidTerm;

public class Crop {
    private String name;
    @SuppressWarnings("unused")
    private int growthDays;
    private int waterNeeded;
    private int waterGiven;
    private boolean isHarvestable;
    private boolean isPlanted;

    public Crop(String name, int growthDays, int waterNeeded) {
        this.name = name;
        this.growthDays = growthDays;
        this.waterNeeded = waterNeeded;
        this.waterGiven = 0;
        this.isHarvestable = false;
        this.isPlanted = false;
    }

    public void water() {
        if (isPlanted) {
            waterGiven++;
            System.out.println(name + " has been watered.");
            if (waterGiven >= waterNeeded) {
                isHarvestable = true;
                System.out.println(name + " is ready to harvest!");
            }
        } else {
            System.out.println("No plant is planted in this land.");
        }
    }

    public void crop() {
        isPlanted = true;
        waterGiven = 0;
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
        waterGiven = 0;
        isHarvestable = false;
    }
}

package MidTerm;

public class Crop {
    private String name;
    private int growthDays; // Total growth days required
    private int currentGrowthDays; // Current growth progress
    private int waterNeeded;
    private int waterGiven;
    private int fertilizerGiven;
    private int pestsControlled;
    private boolean isHarvestable;
    private boolean isPlanted;
    private boolean hasPests;

    public Crop(String name, int growthDays, int waterNeeded) {
        this.name = name;
        this.growthDays = growthDays;
        this.currentGrowthDays = 0;
        this.waterNeeded = waterNeeded;
        this.waterGiven = 0;
        this.fertilizerGiven = 0;
        this.pestsControlled = 0;
        this.isHarvestable = false;
        this.isPlanted = false;
        this.hasPests = false;
    }

    public void plant() {
        isPlanted = true;
        currentGrowthDays = 0;
        waterGiven = 0;
        fertilizerGiven = 0;
        pestsControlled = 0;
        isHarvestable = false;
        hasPests = Math.random() > 0.7; // 30% chance of pests
        System.out.println(name + " has been planted.\n");
        if (hasPests) {
            System.out.println("Warning: Pests have appeared on " + name + ". You need to control them!\n");
        }
    }

    public void water() {
        if (isPlanted) {
            waterGiven++;
            System.out.println(name + " has been watered.");
            if (waterGiven >= waterNeeded && fertilizerGiven > 0 && pestsControlled > 0) {
                currentGrowthDays++;
                System.out.println(name + " is growing. Growth progress: " + currentGrowthDays + "/" + growthDays);
            }
            checkIfHarvestable();
        } else {
            System.out.println("No plant is planted in this land.");
        }
    }

    public void fertilize() {
        if (isPlanted) {
            fertilizerGiven++;
            System.out.println(name + " has been fertilized.");
            checkIfHarvestable();
        } else {
            System.out.println("No plant is planted in this land.");
        }
    }

    public void controlPests() {
        if (isPlanted && hasPests) {
            pestsControlled++;
            hasPests = false;
            System.out.println("Pests have been controlled on " + name + ".");
            checkIfHarvestable();
        } else if (!hasPests) {
            System.out.println(name + " has no pests.");
        }
    }

    private void checkIfHarvestable() {
        if (currentGrowthDays >= growthDays && waterGiven >= waterNeeded && fertilizerGiven > 0
                && pestsControlled > 0) {
            isHarvestable = true;
            System.out.println(name + " is ready to harvest!");
        } else {
            System.out.println(
                    "Time left until harvest for " + name + ": " + (growthDays - currentGrowthDays) + " days.\n");
        }
    }

    public boolean isReadyToHarvest() {
        return isHarvestable;
    }

    public String getName() {
        return name;
    }

    public void reset() {
        isPlanted = false;
        waterGiven = 0;
        fertilizerGiven = 0;
        pestsControlled = 0;
        currentGrowthDays = 0;
        isHarvestable = false;
    }
}

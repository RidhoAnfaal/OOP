package MidTerm;

public class Player {
    private String name;
    private int energy;
    private int gold;
    private String[] inventory;
    private int cropCount;

    public Player(String name) {
        this.name = name;
        this.energy = 100;
        this.gold = 500;
        this.inventory = new String[10];
        this.cropCount = 0;
    }

    public void showStatus() {
        System.out.println("Player: " + name);
        System.out.println("Energy: " + energy);
        System.out.println("Gold: " + gold);
        System.out.println("Inventory: ");
        for (int i = 0; i < cropCount; i++) {
            System.out.println("- " + inventory[i]);
        }
    }

    public void rest() {
        energy = 100;
        System.out.println(name + " is resting. Energy restored to full.");
    }

    public void reduceEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
        } else {
            System.out.println("Not enough energy!");
        }
    }

    public void addCropToInventory(String crop) {
        if (cropCount < inventory.length) {
            inventory[cropCount++] = crop;
            System.out.println(crop + " added to inventory.");
        } else {
            System.out.println("Inventory full.");
        }
    }

    public void sellCrops() {
        if (cropCount > 0) {
            int income = cropCount * 100;
            gold += income;
            cropCount = 0;
            System.out.println("Crops sold for " + income + " gold.");
        } else {
            System.out.println("No crops to sell.");
        }
    }
}

package MidTerm;

import java.util.ArrayList;

public class Player {
    private String name;
    private int energy;
    private int gold;
    private ArrayList<String> cropInventory;
    private ArrayList<Land> lands;

    public Player(String name) {
        this.name = name;
        this.energy = 100;
        this.gold = 500;
        this.cropInventory = new ArrayList<>();
        this.lands = new ArrayList<>();
        // Player starts with one land by default
        Land starterLand = new Land(0, 1); // First land is free
        starterLand.buyLand(this);
        lands.add(starterLand); // Add to the player's list of owned lands
    }

    public void showStatus() {
        System.out.println("======= Player Status =======");
        System.out.println("Player: " + name);
        System.out.println("Energy: " + energy);
        System.out.println("Gold: " + gold);
        System.out.println("Inventory: ");
        for (String crop : cropInventory) {
            System.out.println("- " + crop);
        }
        System.out.println("Owned Lands: " + lands.size() + " plot(s)");
        for (Land land : lands) {
            System.out.println(" - Land " + land.getLandNumber());
        }
        System.out.println("");
    }

    public void rest() {
        energy = 100;
        System.out.println(name + " is resting. Energy restored to full.\n");
    }

    public void reduceEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
        } else {
            System.out.println("Not enough energy!\n");
        }
    }

    public void addCropToInventory(String crop) {
        cropInventory.add(crop);
        System.out.println(crop + " added to inventory.");
    }

    public void sellCrops() {
        if (cropInventory.size() > 0) {
            int income = cropInventory.size() * 100;
            gold += income;
            cropInventory.clear();
            System.out.println("Crops sold for " + income + " gold.");
        } else {
            System.out.println("No crops to sell.");
        }
        System.out.println("");
    }

    public int getGold() {
        return gold;
    }

    public void reduceGold(int amount) {
        gold -= amount;
    }

    public ArrayList<Land> getLands() {
        return lands;
    }

    public void buyLand(Land land) {
        lands.add(land); // Add land to player's list of owned lands
        System.out.println("You now own land " + land.getLandNumber() + ".\n");
    }
}

package MidTerm;

import java.util.ArrayList;

public class Player {
    private String name;
    private int energy;
    private int gold;
    private ArrayList<String> inventory;

    public Player(String name) {
        this.name = name;
        this.energy = 100;
        this.gold = 500;
        this.inventory = new ArrayList<>();
    }

    public void showStatus() {
        System.out.println("Player: " + name);
        System.out.println("Energy: " + energy);
        System.out.println("Gold: " + gold);
        System.out.println("Inventory: ");
        if (inventory.isEmpty()) {
            System.out.println("  No crops in inventory.");
        } else {
            for (String crop : inventory) {
                System.out.println("  - " + crop);
            }
        }
        System.out.println();
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
        inventory.add(crop);
        System.out.println(crop + " added to inventory.\n");
    }

    public void sellCrops() {
        if (!inventory.isEmpty()) {
            int income = inventory.size() * 100;
            gold += income;
            inventory.clear();
            System.out.println("Crops sold for " + income + " gold.\n");
        } else {
            System.out.println("No crops to sell.\n");
        }
    }

    public int getGold() {
        return gold;
    }

    public void reduceGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            System.out.println("Gold reduced by " + amount + ". Remaining gold: " + gold + "\n");
        } else {
            System.out.println("Not enough gold to make this purchase.\n");
        }
    }

    public boolean hasEnoughGold(int amount) {
        return gold >= amount;
    }
}

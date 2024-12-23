package MidTerm;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int money;
    int energy;
    List<Crop> inventory;

    public Player(String name) {
        this.name = name;
        this.money = 100;
        this.energy = 100;
        this.inventory = new ArrayList<>();
    }

    public void harvestCrop(Crop crop) {
        crop.harvest();
        inventory.add(crop);
        System.out.println(name + " has harvested " + crop.name);
        System.out.println("");
    }

    public void rest() {
        energy = 100;
        System.out.println(name + " has rested and recovered energy.\n");
    }

    public boolean hasEnoughEnergy(int cost) {
        if (energy >= cost) {
            energy -= cost;
            return true;
        } else {
            System.out.println("Not enough energy to perform this action.\n");
            return false;
        }
    }

    public void sellCrop(Crop crop) {
        if (inventory.remove(crop)) {
            money += 50; // harga jualan
            System.out.println(name + " sold " + crop.name + ". Current money: " + money);
        } else {
            System.out.println("You don't have " + crop.name + " in your inventory.");
        }
        System.out.println("");
    }

    public void checkStatus() {
        System.out.println("Player Name: " + name);
        System.out.println("Energy: " + energy);
        System.out.println("Money: " + money);
        System.out.println("Inventory: ");
        if (inventory.isEmpty()) {
            System.out.println("No harvests in inventory.");
        } else {
            for (Crop crop : inventory) {
                System.out.println("- " + crop.name);
            }
        }
        System.out.println("");
    }
}

package MidTerm;

import java.util.Scanner;

public class HarvestMoonSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize player with starting land
        Player player = new Player("Ridho");
        Time time = new Time();
        Weather weather = new Weather();

        // Initialize crops
        Crop rice = new Crop("Rice", 3, 2);
        Crop corn = new Crop("Corn", 4, 3);

        // Add additional land to buy
        Land land2 = new Land(300, 2);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== FARM SIMULATOR ===");
            System.out.println("1. Buy Land 2 (300 Gold)");
            System.out.println("2. Plant Rice on a Land");
            System.out.println("3. Plant Corn on a Land");
            System.out.println("4. Water Crops");
            System.out.println("5. Fertilize Crops");
            System.out.println("6. Control Pests");
            System.out.println("7. Harvest Crops");
            System.out.println("8. Check Weather");
            System.out.println("9. Next Day");
            System.out.println("10. Rest (Restore Energy)");
            System.out.println("11. Sell Crops");
            System.out.println("12. Player Status");
            System.out.println("13. Exit");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    land2.buyLand(player);
                    player.buyLand(land2); // Add to player's land list after buying
                    break;
                case 2:
                    plantCrop(player, rice);
                    break;
                case 3:
                    plantCrop(player, corn);
                    break;
                case 4:
                    waterCrops(player);
                    break;
                case 5:
                    fertilizeCrops(player);
                    break;
                case 6:
                    controlPests(player);
                    break;
                case 7:
                    harvestCrops(player);
                    break;
                case 8:
                    weather.changeWeather();
                    break;
                case 9:
                    time.nextDay();
                    player.reduceEnergy(15);
                    break;
                case 10:
                    player.rest();
                    break;
                case 11:
                    player.sellCrops();
                    break;
                case 12:
                    player.showStatus();
                    break;
                case 13:
                    isRunning = false;
                    System.out.println("Thank you for playing!\n");
                    break;
                default:
                    System.out.println("Invalid choice.\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void plantCrop(Player player, Crop crop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose land to plant " + crop.getName() + ": ");
        for (Land land : player.getLands()) {
            if (!land.hasCrop()) {
                System.out.println("Land " + land.getLandNumber() + " is available.");
            }
        }
        System.out.print("Enter land number: ");
        int landNumber = scanner.nextInt();
        for (Land land : player.getLands()) {
            if (land.getLandNumber() == landNumber && !land.hasCrop()) {
                land.plantCrop(crop);
                return;
            }
        }
        System.out.println("Invalid land number or land is already planted.\n");
    }

    public static void waterCrops(Player player) {
        for (Land land : player.getLands()) {
            if (land.hasCrop()) {
                land.water();
            }
        }
    }

    public static void fertilizeCrops(Player player) {
        for (Land land : player.getLands()) {
            if (land.hasCrop()) {
                land.fertilize();
            }
        }
    }

    public static void controlPests(Player player) {
        for (Land land : player.getLands()) {
            if (land.hasCrop()) {
                land.controlPests();
            }
        }
    }

    public static void harvestCrops(Player player) {
        for (Land land : player.getLands()) {
            if (land.hasCrop()) {
                land.harvest(player);
            }
        }
    }
}

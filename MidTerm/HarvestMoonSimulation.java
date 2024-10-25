package MidTerm;

import java.util.ArrayList;
import java.util.Scanner;

public class HarvestMoonSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Ridho");
        ArrayList<Land> lands = new ArrayList<>();
        lands.add(new Land());
        Time time = new Time();
        Weather weather = new Weather();
        Crop rice = new Crop("Rice", 3, 2);
        Crop corn = new Crop("Corn", 4, 2);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== FARM SIMULATOR ===");
            System.out.println("1. Plant Rice");
            System.out.println("2. Plant Corn");
            System.out.println("3. Water Crops");
            System.out.println("4. Harvest Crops");
            System.out.println("5. Check Weather");
            System.out.println("6. Buy Land");
            System.out.println("7. Next Day");
            System.out.println("8. Rest");
            System.out.println("9. Sell Crops");
            System.out.println("10. Player Status");
            System.out.println("11. Exit");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.reduceEnergy(10);
                    plantCrop(lands, rice, scanner);
                    break;
                case 2:
                    player.reduceEnergy(10);
                    plantCrop(lands, corn, scanner);
                    break;
                case 3:
                    player.reduceEnergy(5);
                    for (Land land : lands) {
                        if (land.hasCrop()) {
                            land.water();
                        }
                    }
                    break;
                case 4:
                    for (Land land : lands) {
                        land.harvest(player);
                    }
                    break;
                case 5:
                    weather.changeWeather();
                    break;
                case 6:
                    if (player.getGold() >= 200) {
                        lands.add(new Land());
                        player.reduceGold(200);
                        System.out.println("New land purchased!");
                    } else {
                        System.out.println("Not enough gold to buy land.");
                    }
                    break;
                case 7:
                    time.nextDay();
                    weather.changeWeather();
                    for (Land land : lands) {
                        if (weather.isRainy() && land.hasCrop()) {
                            land.getCrop().water();
                        }
                        land.nextDay();
                    }
                    player.reduceEnergy(15);
                    break;
                case 8:
                    player.rest();
                    break;
                case 9:
                    player.sellCrops();
                    break;
                case 10:
                    player.showStatus();
                    System.out.println("Owned Lands: " + lands.size());
                    break;
                case 11:
                    isRunning = false;
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void plantCrop(ArrayList<Land> lands, Crop crop, Scanner scanner) {
        System.out.println("Select land to plant on (1 to " + lands.size() + "): ");
        int landChoice = scanner.nextInt();
        if (landChoice > 0 && landChoice <= lands.size()) {
            Land selectedLand = lands.get(landChoice - 1);
            if (!selectedLand.hasCrop()) {
                selectedLand.crop(crop);
            } else {
                System.out.println("This land is already occupied.");
            }
        } else {
            System.out.println("Invalid land choice.");
        }
    }
}

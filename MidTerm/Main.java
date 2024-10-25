package MidTerm;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Ridho");
        Land land = new Land("Loamy", 100);
        Time time = new Time();
        Weather weather = new Weather();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====== FARM SIMULATOR =====");
            System.out.println("1. Plant Crops");
            System.out.println("2. Fertilize Crops");
            System.out.println("3. Water Crops");
            System.out.println("4. Pest Control");
            System.out.println("5. Rest");
            System.out.println("6. Advance to Next Day");
            System.out.println("7. Check Weather");
            System.out.println("8. Sell Harvest");
            System.out.println("9. Harvest Crops");
            System.out.println("10. Check Player Status");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> plantCrop(scanner, land, player);
                case 2 -> performCropAction(scanner, land, "fertilize", player);
                case 3 -> performCropAction(scanner, land, "water", player);
                case 4 -> performCropAction(scanner, land, "pest control", player);
                case 5 -> player.rest();
                case 6 -> nextDay(land, player, time, weather);
                case 7 -> System.out.println("Current weather: " + weather.getCondition() + "\n");
                case 8 -> sellCrop(scanner, player);
                case 9 -> harvest(scanner, land, player);
                case 10 -> player.checkStatus();
                case 11 -> {
                    System.out.println("Exiting game.");
                    return;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void plantCrop(Scanner scanner, Land land, Player player) {
        if (!player.hasEnoughEnergy(10))
            return;

        System.out.print("Choose a crop to plant (1. Rice, 2. Corn, 3. Vegetables): ");
        int cropOption = scanner.nextInt();
        Crop cropToPlant = switch (cropOption) {
            case 1 -> new Rice();
            case 2 -> new Corn();
            case 3 -> new Vegetables();
            default -> null;
        };
        if (cropToPlant != null) {
            land.plant(cropToPlant);
        } else {
            System.out.println("Invalid crop option.");
        }
    }

    private static void performCropAction(Scanner scanner, Land land, String action, Player player) {
        if (!player.hasEnoughEnergy(5))
            return;

        System.out.println("Choose a crop to " + action + ": ");
        for (int i = 0; i < land.getCrops().size(); i++) {
            System.out.println((i + 1) + ". " + land.getCrops().get(i).name + " (Ready in "
                    + land.getCrops().get(i).getDaysUntilHarvest() + " days)");
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < land.getCrops().size()) {
            Crop selectedCrop = land.getCrops().get(choice);
            switch (action) {
                case "fertilize" -> land.fertilize(selectedCrop);
                case "water" -> land.water(selectedCrop);
                case "pest control" -> land.pestControl(selectedCrop);
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void nextDay(Land land, Player player, Time time, Weather weather) {
        time.passDay();
        weather.changeWeather();
        boolean isRainy = weather.isRainy();

        Iterator<Crop> iterator = land.getCrops().iterator();
        while (iterator.hasNext()) {
            Crop crop = iterator.next();
            crop.grow();
            crop.incrementDaysPlanted();

            if (isRainy) {
                crop.water();
                System.out.println("The rain watered " + crop.name + "!");
            }
        }
    }

    private static void sellCrop(Scanner scanner, Player player) {
        System.out.println("Choose a crop to sell: ");
        for (int i = 0; i < player.inventory.size(); i++) {
            System.out.println((i + 1) + ". " + player.inventory.get(i).name);
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < player.inventory.size()) {
            player.sellCrop(player.inventory.get(choice));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void harvest(Scanner scanner, Land land, Player player) {
        System.out.println("Choose a crop to manually harvest: ");
        for (int i = 0; i < land.getCrops().size(); i++) {
            Crop crop = land.getCrops().get(i);
            System.out.println((i + 1) + ". " + crop.name + (crop.isReadyToHarvest() ? " (Ready)" : " (Not Ready)"));
        }
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < land.getCrops().size()) {
            Crop selectedCrop = land.getCrops().get(choice);
            if (selectedCrop.isReadyToHarvest()) {
                player.harvestCrop(selectedCrop);
                land.getCrops().remove(selectedCrop);
            } else {
                System.out.println("This crop is not ready for harvest yet.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

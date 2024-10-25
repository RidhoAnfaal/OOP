package MidTerm;

import java.util.Scanner;

public class FarmSimulation {
    public static void main(String[] args) {
        Player player = new Player("Ridho");

        Land land = new Land("Loamy", 100);

        Crop rice = new Rice();
        Crop corn = new Corn();
        Crop vegetables = new Vegetables();

        Time time = new Time();
        Weather weather = new Weather();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("====== FARM SIMULATOR ======:");
            System.out.println("1. Planting Plants");
            System.out.println("2. Fertilizing Plants");
            System.out.println("3. Watering Plants");
            System.out.println("4. Getting rid of pests on plants");
            System.out.println("5. Rest");
            System.out.println("6. Next Day");
            System.out.println("7. Check the Weather");
            System.out.println("8. Sell the Harvest");
            System.out.println("9. Check Player Status");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Choose a crop to plant (1. Rice, 2. Corn, 3. Vegetables): ");
                    int cropOption = scanner.nextInt();
                    Crop cropToPlant;
                    switch (cropOption) {
                        case 1:
                            cropToPlant = new Rice();
                            break;
                        case 2:
                            cropToPlant = new Corn();
                            break;
                        case 3:
                            cropToPlant = new Vegetables();
                            break;
                        default:
                            System.out.println("Invalid crop option.");
                            continue;
                    }
                    land.plant(cropToPlant);
                    break;
                case 2:
                    System.out.print("Choose a crop to fertilize: \n");
                    for (int i = 0; i < land.getCrops().size(); i++) {
                        System.out.println((i + 1) + ". " + land.getCrops().get(i).name);
                    }
                    int fertilizeOption = scanner.nextInt() - 1;
                    if (fertilizeOption >= 0 && fertilizeOption < land.getCrops().size()) {
                        land.fertilize(land.getCrops().get(fertilizeOption));
                    } else {
                        System.out.println("Invalid crop option.");
                    }
                    break;
                case 3:
                    System.out.print("Choose a crop to water: \n");
                    for (int i = 0; i < land.getCrops().size(); i++) {
                        System.out.println((i + 1) + ". " + land.getCrops().get(i).name);
                    }
                    int waterOption = scanner.nextInt() - 1;
                    if (waterOption >= 0 && waterOption < land.getCrops().size()) {
                        land.water(land.getCrops().get(waterOption));
                    } else {
                        System.out.println("Invalid crop option.");
                    }
                    break;
                case 4:
                    System.out.print("Choose a crop to apply pest control: \n");
                    for (int i = 0; i < land.getCrops().size(); i++) {
                        System.out.println((i + 1) + ". " + land.getCrops().get(i).name);
                    }
                    int pestControlOption = scanner.nextInt() - 1;
                    if (pestControlOption >= 0 && pestControlOption < land.getCrops().size()) {
                        land.pestControl(land.getCrops().get(pestControlOption));
                    } else {
                        System.out.println("Invalid crop option.");
                    }
                    break;
                case 5:
                    player.rest();
                    break;
                case 6:
                    time.passDay();
                    weather.changeWeather();
                    for (Crop crop : land.getCrops()) {
                        crop.grow();
                        if (crop.isReadyToHarvest(time.getDays())) {
                            player.harvestCrop(crop);
                            land.getCrops().remove(crop);
                        }
                    }
                    break;
                case 7:
                    System.out.println("The weather is: " + weather.getCondition());
                    break;
                case 8:
                    System.out.print("Choose a crop to sell: \n");
                    for (int i = 0; i < player.inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + player.inventory.get(i).name);
                    }
                    int sellOption = scanner.nextInt() - 1;
                    if (sellOption >= 0 && sellOption < player.inventory.size()) {
                        player.sellCrop(player.inventory.get(sellOption));
                    } else {
                        System.out.println("Invalid crop option.");
                    }
                    break;
                case 9:
                    player.checkStatus();
                    break;
                case 10:
                    System.out.println("Exiting game.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
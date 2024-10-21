package MidTerm;

import java.util.Scanner;

public class HarvestMoonSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi objek game
        Player player = new Player("Ridho");
        Land land = new Land();
        Time time = new Time();
        Weather weather = new Weather();

        // Inisialisasi tanaman
        Crop rice = new Crop("Rice", 3, 2); // butuh 3 hari dan 2 kali disiram
        Crop corn = new Crop("Corn", 4, 3); // butuh 4 hari dan 3 kali disiram

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== FARM SIMULATOR ===");
            System.out.println("1. Crop Rice");
            System.out.println("2. Crop Corn");
            System.out.println("3. Water the Crop");
            System.out.println("4. Harvest the Crop");
            System.out.println("5. Check Weather");
            System.out.println("6. Next Day");
            System.out.println("7. Rest (Restore Energy)");
            System.out.println("8. Sell Crops");
            System.out.println("9. Player Status");
            System.out.println("10. Exit");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.reduceEnergy(10);
                    if (!land.hasCrop()) {
                        land.crop(rice);
                    } else {
                        System.out.println("Land is occupied!");
                    }
                    break;
                case 2:
                    player.reduceEnergy(10);
                    if (!land.hasCrop()) {
                        land.crop(corn);
                    } else {
                        System.out.println("Land is occupied!");
                    }
                    break;
                case 3:
                    player.reduceEnergy(5);
                    if (weather.isRainy()) {
                        System.out.println("It's raining, no need to water!");
                    } else {
                        land.water();
                    }
                    break;
                case 4:
                    land.harvest(player);
                    break;
                case 5:
                    weather.changeWeather();
                    break;
                case 6:
                    time.nextDay();
                    player.reduceEnergy(15);
                    break;
                case 7:
                    player.rest();
                    break;
                case 8:
                    player.sellCrops();
                    break;
                case 9:
                    player.showStatus();
                    break;
                case 10:
                    isRunning = false;
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}

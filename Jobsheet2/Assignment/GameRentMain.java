package Jobsheet2.Assignment;

public class GameRentMain {
    public static void main(String[] args) {
        Game game1 = new Game("CyberPunk", 20.000);
        Game game2 = new Game("SPIDER-MAN 2", 24.000);
        Game game3 = new Game("RED DEAD REDEMPTION 2", 22.000);

        RentalTx rental1 = new RentalTx(1, "Jono", game3, 7);
        rental1.displayRentalDetails();

        RentalTx rental2 = new RentalTx(2, "Budi", game1, 3);
        rental2.displayRentalDetails();

        RentalTx rental3 = new RentalTx(3, "Ridho", game2, 14);
        rental3.displayRentalDetails();
    }
}

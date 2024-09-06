package Jobsheet2.Assignment;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class RentalTx {
    private int id, rentalDuration;
    private String memberName;
    private Game game;
    private double amountToBePaid;

    public RentalTx(int id, String memberName, Game game, int rentalDuration) {
        this.id = id;
        this.memberName = memberName;
        this.game = game;
        this.rentalDuration = rentalDuration;
        this.amountToBePaid = calculateTotalToPay();
    }

    public double calculateTotalToPay() {
        return game.getPricePerDay() * rentalDuration;
    }

    public void displayRentalDetails() {
        // format to decimal
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormat formatter = new DecimalFormat("#,##0.000", symbols);
        String formattedPrice = formatter.format(amountToBePaid);

        System.out.println("Rental ID: " + id);
        System.out.println("Member Name: " + memberName);
        System.out.println("Game: " + game.getName());
        System.out.println("Rental Duration: " + rentalDuration + " days");
        System.out.println("Amount to Pay: Rp." + formattedPrice);
        System.out.println("=========================================================");
    }
}

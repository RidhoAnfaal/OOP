package Jobsheet2.Assignment;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Barang {
    private String code, itemName;
    private int basePrice;
    private float discount;

    public Barang(String code, String itemName, int basePrice, float discount) {
        this.code = code;
        this.itemName = itemName;
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int calculateSellingPrice() {
        int sellingPrice = basePrice - (int) (discount / 100.0 * basePrice);
        return sellingPrice;
    }

    public void displayData() {
        // format to decimal
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);
        String formattedPrice = formatter.format(calculateSellingPrice());

        System.out.println("Code: " + code);
        System.out.println("Item name: " + itemName);
        System.out.println("Base price: Rp." + basePrice);
        System.out.println("discount: " + discount + "%");
        System.out.println("Selling price: Rp." + formattedPrice);
    }

    public static void main(String[] args) {
        Barang barang = new Barang("Book001", "Java OOP book", 100000, 25);
        barang.displayData();
    }
}

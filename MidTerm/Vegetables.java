package MidTerm;

public class Vegetables extends Crop {
    public Vegetables() {
        super("Vegetables", 2, 2);
    }

    @Override
    public void grow() {
        System.out.println("Vegetables are growing.\n");
    }
}
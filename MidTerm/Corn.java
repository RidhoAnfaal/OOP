package MidTerm;

public class Corn extends Crop {
    public Corn() {
        super("Corn", 3, 3);
    }

    @Override
    public void grow() {
        System.out.println("Corn is growing.\n");
    }
}
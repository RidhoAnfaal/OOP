package MidTerm;

public class Rice extends Crop {
    public Rice() {
        super("Rice", 2, 2);
    }

    @Override
    public void grow() {
        System.out.println("Rice is growing.\n");
    }
}
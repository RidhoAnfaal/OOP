package Jobsheet2.Assignment;

public class Lingkaran {
    private static final double phi = 3.14;
    private double r;

    public Lingkaran(double r) {
        this.r = r;
    }

    public double calculateArea() {
        return phi * r * r;
    }

    public double calculateCircumference() {
        return 2 * phi * r;
    }

    public static void main(String[] args) {
        Lingkaran lingkaran = new Lingkaran(5);
        System.out.printf("Circle area: %.2f\n", lingkaran.calculateArea());
        System.out.printf("Circumference of circle: %.2f\n", lingkaran.calculateCircumference());
    }
}
